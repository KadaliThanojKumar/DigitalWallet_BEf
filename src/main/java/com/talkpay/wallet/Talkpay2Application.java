//package com.talkpay.wallet;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//
//@SpringBootApplication
//public class Talkpay2Application {
//
//	public static void main(String[] args) {
//		SpringApplication.run(Talkpay2Application.class, args);
//	}
//
//}
//
//package com.talkpay.wallet;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//
//@SpringBootApplication
//public class Talkpay2Application extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Talkpay2Application.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Talkpay2Application.class, args);
//    }
//}

//
//package com.talkpay.wallet;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//@SpringBootApplication
//public class Talkpay2Application extends SpringBootServletInitializer {
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(Talkpay2Application.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Talkpay2Application.class, args);
//    }
//}
//
//

//package com.talkpay.wallet;
//
//import org.springframework.boot.SpringApplication;
//import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.boot.builder.SpringApplicationBuilder;
//import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//
//@SpringBootApplication
//public class Talkpay2Application extends SpringBootServletInitializer {
//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(Talkpay2Application.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication.run(Talkpay2Application.class, args);
//    }
//}

package com.talkpay.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class Talkpay2Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Talkpay2Application.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(Talkpay2Application.class, args);
    }
}