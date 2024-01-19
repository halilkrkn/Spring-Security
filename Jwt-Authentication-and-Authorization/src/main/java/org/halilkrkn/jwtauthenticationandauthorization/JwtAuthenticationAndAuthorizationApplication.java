package org.halilkrkn.jwtauthenticationandauthorization;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JwtAuthenticationAndAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationAndAuthorizationApplication.class, args);
        System.out.println("System is Running");
    }

}
