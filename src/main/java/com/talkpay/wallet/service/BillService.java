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
//import java.util.List;
//
//@Service
//public class BillService {
//
//    @Autowired
//    private BillRepository billRepository;
//
//    @Autowired
//    private UserRepository userRepository;
//
//    @Autowired
//    private TransactionRepository transactionRepository;
//
//    public Bill payBill(Long userId, String billType, double amount) throws Exception {
//        User user = userRepository.findById(userId)
//                .orElseThrow(() -> new Exception("User not found"));
//
//        // Calculate wallet balance
//        List<Transaction> transactions = transactionRepository.findByUserOrderByTimestampDesc(user);
//        double balance = transactions.stream()
//                .mapToDouble(t -> t.getType().equals("Sent") ? -t.getAmount() : t.getAmount())
//                .sum();
//
//        if (balance < amount) {
//            throw new Exception("Insufficient balance");
//        }
//
//        // Deduct amount from wallet (record a transaction)
//        Transaction transaction = new Transaction(user, "Sent", amount, LocalDateTime.now(), "Bill: " + billType);
//        transactionRepository.save(transaction);
//
//        // Save bill
//        Bill bill = new Bill(userId, billType, amount, "Completed", LocalDateTime.now());
//        return billRepository.save(bill);
//    }
//
//    public List<Bill> getBills(Long userId) {
//        return billRepository.findByUserIdOrderByTimestampDesc(userId);
//    }
//}
