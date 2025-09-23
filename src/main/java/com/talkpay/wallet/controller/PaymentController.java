//package com.talkpay.wallet.controller;
//
//import com.talkpay.wallet.model.Bill;
//import com.talkpay.wallet.service.PaymentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/payments")
//@CrossOrigin(origins = "http://localhost:5173")
//public class PaymentController {
//
//    @Autowired
//    private PaymentService paymentService;
//
//    @PostMapping("/pay")
//    public ResponseEntity<?> payBill(@RequestBody Map<String, String> body) {
//        try {
//            Long userId = Long.parseLong(body.get("userId"));
//            String billName = body.get("billName");
//            double amount = Double.parseDouble(body.get("amount"));
//
//            Bill bill = paymentService.payBill(userId, billName, amount);
//            return ResponseEntity.ok(Map.of("message", "Bill paid successfully", "bill", bill));
//        } catch (Exception e) {
//            return ResponseEntity.badRequest().body(Map.of("error", e.getMessage()));
//        }
//    }
//}
