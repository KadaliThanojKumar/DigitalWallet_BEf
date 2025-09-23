package com.talkpay.wallet.controller;

import com.talkpay.wallet.model.Transaction;
import com.talkpay.wallet.model.User;
import com.talkpay.wallet.repository.TransactionRepository;
import com.talkpay.wallet.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/wallet")
@CrossOrigin(origins = "http://localhost:5173")
public class WalletController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    // Get wallet info (balance + transactions)
    @GetMapping("/{userId}")
    public ResponseEntity<?> getWallet(@PathVariable Long userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return ResponseEntity.badRequest().body(Map.of("error", "User not found"));

        List<Transaction> transactions = transactionRepository.findByUserOrderByTimestampDesc(user);
        double balance = transactions.stream().mapToDouble(t -> t.getType().equals("Sent") ? -t.getAmount() : t.getAmount()).sum();

        return ResponseEntity.ok(Map.of(
                "user", Map.of("id", user.getId(), "email", user.getEmail()),
                "balance", balance,
                "transactions", transactions
        ));
    }

    // Add money
    @PostMapping("/add")
    public ResponseEntity<?> addMoney(@RequestBody Map<String, String> body) {
        Long userId = Long.parseLong(body.get("userId"));
        Double amount = Double.parseDouble(body.get("amount"));

        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return ResponseEntity.badRequest().body(Map.of("error", "User not found"));

        Transaction transaction = new Transaction(user, "Added", amount, LocalDateTime.now(), null);
        transactionRepository.save(transaction);

        return ResponseEntity.ok(Map.of("message", "Money added successfully!", "transaction", transaction));
    }

    // Send money
    @PostMapping("/send")
    public ResponseEntity<?> sendMoney(@RequestBody Map<String, String> body) {
        Long senderId = Long.parseLong(body.get("senderId"));
        Long recipientId = Long.parseLong(body.get("recipientId"));
        Double amount = Double.parseDouble(body.get("amount"));

        User sender = userRepository.findById(senderId).orElse(null);
        User recipient = userRepository.findById(recipientId).orElse(null);

        if (sender == null || recipient == null) return ResponseEntity.badRequest().body(Map.of("error", "User not found"));

        // Check sender balance
        List<Transaction> senderTransactions = transactionRepository.findByUserOrderByTimestampDesc(sender);
        double senderBalance = senderTransactions.stream().mapToDouble(t -> t.getType().equals("Sent") ? -t.getAmount() : t.getAmount()).sum();
        if (senderBalance < amount) return ResponseEntity.badRequest().body(Map.of("error", "Insufficient balance"));

        // Deduct from sender
        Transaction sendTransaction = new Transaction(sender, "Sent", amount, LocalDateTime.now(), recipient.getEmail());
        transactionRepository.save(sendTransaction);

        // Add to recipient
        Transaction receiveTransaction = new Transaction(recipient, "Received", amount, LocalDateTime.now(), sender.getEmail());
        transactionRepository.save(receiveTransaction);

        return ResponseEntity.ok(Map.of("message", "Money sent successfully!", "transaction", sendTransaction));
    }
}
