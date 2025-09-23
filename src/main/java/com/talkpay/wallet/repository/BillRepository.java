//package com.talkpay.wallet.repository;
//
//import com.talkpay.wallet.model.Bill;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface BillRepository extends JpaRepository<Bill, Long> {
//    List<Bill> findByUserIdOrderByTimestampDesc(Long userId);
//}

//
//package com.talkpay.wallet.repository;
//
//import com.talkpay.wallet.model.Bill;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface BillRepository extends JpaRepository<Bill, Long> {
//    List<Bill> findByUserIdOrderByPaidAtDesc(Long userId);
//}
package com.talkpay.wallet.repository;

import com.talkpay.wallet.model.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillRepository extends JpaRepository<Bill, Long> {
    List<Bill> findByUserIdOrderByPaidAtDesc(Long userId);
}
