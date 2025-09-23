//package com.talkpay.wallet.service;
//
//import com.talkpay.wallet.model.Bill;
//import com.talkpay.wallet.model.Transaction;
//import com.talkpay.wallet.model.User;
//import com.talkpay.wallet.repository.BillRepository;
//import com.talkpay.wallet.repository.TransactionRepository;
//import com.talkpay.wallet.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//
//@Service
//public class PaymentService {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    @Autowired
//    private BillRepository billRepository;
//
//    public Bill payBill(Long userId, String billName, double amount) throws Exception {
//        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("User not found"));
//
//        // Calculate wallet balance
//        double balance = transactionRepository.findByUserOrderByTimestampDesc(user)
//                .stream()
//                .mapToDouble(t -> t.getType().equals("Sent") ? -t.getAmount() : t.getAmount())
//                .sum();
//
//        if (balance < amount) throw new Exception("Insufficient balance");
//
//        // Deduct money via transaction
//        Transaction transaction = new Transaction(user, "Sent", amount, LocalDateTime.now(), "Bill: " + billName);
//        transactionRepository.save(transaction);
//
//        // Create Bill record
//        Bill bill = new Bill(userId, billName, amount, LocalDateTime.now());
//        return billRepository.save(bill);
//    }
//}
