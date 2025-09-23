package com.talkpay.wallet.controller;

import com.talkpay.wallet.model.Bill;
import com.talkpay.wallet.repository.BillRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/bills")
@CrossOrigin(origins = "http://localhost:5173") // your React frontend
public class BillController {

    private final BillRepository billRepository;

    public BillController(BillRepository billRepository) {
        this.billRepository = billRepository;
    }

    // Add a new bill payment
    @PostMapping("/add")
    public Bill addBill(@RequestBody Bill bill) {
        bill.setStatus("Completed");           // default status
        bill.setPaidAt(LocalDateTime.now());   // timestamp of payment
        return billRepository.save(bill);
    }

    // Get all bills for a user
    @GetMapping("/user/{userId}")
    public List<Bill> getBillsByUser(@PathVariable Long userId) {
        return billRepository.findByUserIdOrderByPaidAtDesc(userId);
    }
}
