////package com.talkpay.wallet.repository;
////
////import com.talkpay.wallet.model.User;
////import org.springframework.data.jpa.repository.JpaRepository;
////import java.util.Optional;
////
////public interface UserRepository extends JpaRepository<User, Long> {
////    Optional<User> findByEmail(String email);
////}
////
////package com.talkpay.wallet.repository;
////
////import com.talkpay.wallet.model.User;
////import org.springframework.data.jpa.repository.JpaRepository;
////import java.util.Optional;
////
////public interface UserRepository extends JpaRepository<User, Long> {
////    Optional<User> findByEmail(String email);
////}
//package com.talkpay.wallet.repository;
//
//import com.talkpay.wallet.model.User;
//import org.springframework.data.jpa.repository.JpaRepository;
//import java.util.Optional;
//
//public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByEmail(String email);
//}
//

package com.talkpay.wallet.repository;

import com.talkpay.wallet.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}

