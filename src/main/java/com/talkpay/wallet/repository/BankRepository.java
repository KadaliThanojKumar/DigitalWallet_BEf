package com.talkpay.wallet.repository;

import com.talkpay.wallet.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BankRepository extends JpaRepository<Bank, Long> {
    List<Bank> findByUserId(Long userId);
}
