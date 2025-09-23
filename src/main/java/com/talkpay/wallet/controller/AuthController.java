//package com.talkpay.wallet.controller;
//
//import com.talkpay.wallet.model.User;
//import com.talkpay.wallet.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:3000")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    // Signup endpoint
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
//        String email = body.get("email");
//        String password = body.get("password");
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        if (userRepository.findByEmail(email).isPresent()) {
//            return ResponseEntity
//                    .status(HttpStatus.CONFLICT)
//                    .body(Map.of("error", "Email already exists!"));
//        }
//
//        String hashedPassword = passwordEncoder.encode(password);
//        User user = new User(email, hashedPassword);
//        userRepository.save(user);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(Map.of("message", "User registered successfully!"));
//    }
//
//    // Login endpoint (without JWT)
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//        String email = body.get("email");
//        String password = body.get("password");
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        User user = userRepository.findByEmail(email).orElse(null);
//        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
//            return ResponseEntity
//                    .status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid email or password!"));
//        }
//
//        // Return user info only, no token
//        return ResponseEntity.ok(Map.of(
//                "message", "Login successful!",
//                "user", Map.of("id", user.getId(), "email", user.getEmail())
//        ));
//    }
//}
//
//package com.talkpay.wallet.controller;
//
//import com.talkpay.wallet.model.User;
//import com.talkpay.wallet.repository.UserRepository;
//import com.talkpay.wallet.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    // Signup endpoint
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        if (userRepository.findByEmail(email).isPresent()) {
//            return ResponseEntity
//                    .status(HttpStatus.CONFLICT)
//                    .body(Map.of("error", "Email already exists!"));
//        }
//
//        String hashedPassword = passwordEncoder.encode(password);
//        User user = new User(email, hashedPassword);
//        userRepository.save(user);
//
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(Map.of("message", "User registered successfully!"));
//    }
//
//    // Login endpoint
//    
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//    	System.out.println(">>> /api/auth/login called");
//        System.out.println("Request body email: " + body.get("email"));
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity
//                    .status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        User user = userRepository.findByEmail(email).orElse(null);
//
//        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
//            return ResponseEntity
//                    .status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid email or password!"));
//        }
//
//        // ✅ Fixed JwtUtil (Base64, no DatatypeConverter)
//        String token = JwtUtil.generateToken(user.getEmail());
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("user", Map.of("id", user.getId(), "email", user.getEmail()));
//        response.put("token", token);
//
//        return ResponseEntity.ok(response);
//    }
//}
//
//
//package com.talkpay.wallet.controller;
//
//import com.talkpay.wallet.model.User;
//import com.talkpay.wallet.repository.UserRepository;
//import com.talkpay.wallet.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    // Signup endpoint
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        if (userRepository.findByEmail(email).isPresent()) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(Map.of("error", "Email already exists!"));
//        }
//
//        String hashedPassword = passwordEncoder.encode(password);
//        User user = new User(email, hashedPassword);
//        userRepository.save(user);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(Map.of("message", "User registered successfully!"));
//    }
//
//    // Login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        User user = userRepository.findByEmail(email).orElse(null);
//
//        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid email or password!"));
//        }
//
//        String token = JwtUtil.generateToken(user.getEmail());
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("user", Map.of("id", user.getId(), "email", user.getEmail()));
//        response.put("token", token);
//
//        return ResponseEntity.ok(response);
//    }
//}
//package com.talkpay.wallet.controller;
//
//import com.talkpay.wallet.model.User;
//import com.talkpay.wallet.repository.UserRepository;
//import com.talkpay.wallet.security.JwtUtil;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@RestController
//@RequestMapping("/api/auth")
//@CrossOrigin(origins = "http://localhost:3000")
//public class AuthController {
//
//    @Autowired
//    private UserRepository userRepository;
//
//    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//
//    // Signup endpoint
//    @PostMapping("/signup")
//    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//        String name = body.get("name") != null ? body.get("name").trim() : "";
//        String phone = body.get("phone") != null ? body.get("phone").trim() : "";
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        if (userRepository.findByEmail(email).isPresent()) {
//            return ResponseEntity.status(HttpStatus.CONFLICT)
//                    .body(Map.of("error", "Email already exists!"));
//        }
//
//        String hashedPassword = passwordEncoder.encode(password);
//        User user = new User(email, hashedPassword, name, phone);
//        userRepository.save(user);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(Map.of("message", "User registered successfully!"));
//    }
//
//    // Login endpoint
//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
//        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
//        String password = body.get("password") != null ? body.get("password").trim() : null;
//
//        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
//                    .body(Map.of("error", "Email and password must not be empty!"));
//        }
//
//        User user = userRepository.findByEmail(email).orElse(null);
//
//        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
//                    .body(Map.of("error", "Invalid email or password!"));
//        }
//
//        String token = JwtUtil.generateToken(user.getEmail());
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("user", Map.of(
//                "id", user.getId(),
//                "email", user.getEmail(),
//                "name", user.getName(),
//                "phone", user.getPhone()
//        ));
//        response.put("token", token);
//
//        return ResponseEntity.ok(response);
//    }
//
//    // Update Profile
//    @PutMapping("/profile/{id}")
//    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Map<String, String> body) {
//        User user = userRepository.findById(id).orElse(null);
//        if (user == null) return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found!"));
//
//        String name = body.get("name");
//        String phone = body.get("phone");
//        String email = body.get("email");
//
//        if (name != null) user.setName(name.trim());
//        if (phone != null) user.setPhone(phone.trim());
//        if (email != null) user.setEmail(email.trim().toLowerCase());
//
//        userRepository.save(user);
//
//        Map<String, Object> response = new HashMap<>();
//        response.put("user", Map.of(
//                "id", user.getId(),
//                "email", user.getEmail(),
//                "name", user.getName(),
//                "phone", user.getPhone()
//        ));
//
//        return ResponseEntity.ok(response);
//    }
//}


package com.talkpay.wallet.controller;

import com.talkpay.wallet.model.User;
import com.talkpay.wallet.repository.UserRepository;
import com.talkpay.wallet.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:5173") // React frontend URL
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    // Signup endpoint
    @PostMapping("/signup")
    public ResponseEntity<?> signup(@RequestBody Map<String, String> body) {
        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
        String password = body.get("password") != null ? body.get("password").trim() : null;
        String name = body.get("name") != null ? body.get("name").trim() : "";
        String phone = body.get("phone") != null ? body.get("phone").trim() : "";

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Email and password must not be empty!"));
        }

        if (userRepository.findByEmail(email).isPresent()) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("error", "Email already exists!"));
        }

        String hashedPassword = passwordEncoder.encode(password);
        User user = new User(email, hashedPassword, name, phone);
        userRepository.save(user);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "User registered successfully!"));
    }

    // Login endpoint
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> body) {
        String email = body.get("email") != null ? body.get("email").trim().toLowerCase() : null;
        String password = body.get("password") != null ? body.get("password").trim() : null;

        if (email == null || password == null || email.isEmpty() || password.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Map.of("error", "Email and password must not be empty!"));
        }

        User user = userRepository.findByEmail(email).orElse(null);

        if (user == null || !passwordEncoder.matches(password, user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid email or password!"));
        }

        String token = JwtUtil.generateToken(user.getEmail());

        Map<String, Object> response = new HashMap<>();
        response.put("user", Map.of(
                "id", user.getId(),
                "email", user.getEmail(),
                "name", user.getName(),
                "phone", user.getPhone()
        ));
        response.put("token", token);

        return ResponseEntity.ok(response);
    }

    // ✅ Profile Update endpoint
    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateProfile(@PathVariable Long id, @RequestBody Map<String, String> body) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (!optionalUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("error", "User not found"));
        }

        User user = optionalUser.get();
        String name = body.get("name");
        String phone = body.get("phone");
        String email = body.get("email");

        if (name != null && !name.trim().isEmpty()) user.setName(name.trim());
        if (phone != null && !phone.trim().isEmpty()) user.setPhone(phone.trim());
        if (email != null && !email.trim().isEmpty()) user.setEmail(email.trim().toLowerCase());

        userRepository.save(user);

        return ResponseEntity.ok(Map.of(
                "message", "Profile updated successfully",
                "user", Map.of(
                        "id", user.getId(),
                        "email", user.getEmail(),
                        "name", user.getName(),
                        "phone", user.getPhone()
                )
        ));
    }
}
