package com.talkpay.wallet.controller;

import com.talkpay.wallet.model.Bank;
import com.talkpay.wallet.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bank")
@CrossOrigin(origins = "http://localhost:5173")
public class BankController {

    @Autowired
    private BankRepository bankRepository;

    // Get all banks for a user
    @GetMapping("/{userId}")
    public ResponseEntity<?> getBanks(@PathVariable Long userId) {
        List<Bank> banks = bankRepository.findByUserId(userId);
        return ResponseEntity.ok(banks);
    }

    // Add a bank
    @PostMapping("/add")
    public ResponseEntity<?> addBank(@RequestBody Bank bank) {
        if (bank.getUserId() == null || bank.getBankName() == null || bank.getAccountNumber() == null || bank.getRoutingNumber() == null) {
            return ResponseEntity.badRequest().body("Missing required fields");
        }

        Bank savedBank = bankRepository.save(bank);
        return ResponseEntity.ok(savedBank);
    }

    // Delete a bank
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBank(@PathVariable Long id) {
        if (!bankRepository.existsById(id)) {
            return ResponseEntity.badRequest().body("Bank not found");
        }
        bankRepository.deleteById(id);
        return ResponseEntity.ok("Bank deleted successfully");
    }
}
