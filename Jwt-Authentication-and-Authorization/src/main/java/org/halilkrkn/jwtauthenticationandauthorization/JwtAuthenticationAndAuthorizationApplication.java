package org.halilkrkn.jwtauthenticationandauthorization;

import org.halilkrkn.jwtauthenticationandauthorization.auth.AuthenticationService;
import org.halilkrkn.jwtauthenticationandauthorization.auth.RegisterRequest;
import org.halilkrkn.jwtauthenticationandauthorization.user.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static org.halilkrkn.jwtauthenticationandauthorization.user.Role.*;

@SpringBootApplication
public class JwtAuthenticationAndAuthorizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtAuthenticationAndAuthorizationApplication.class, args);
        System.out.println("System is Running");
    }

    @Bean
    public CommandLineRunner commandLineRunner(
            AuthenticationService authenticationService
    ) {
        return args -> {
            var admin = RegisterRequest.builder()
                    .firstName("Admin")
                    .lastName("Admin")
                    .email("Admin@gmail.com")
                    .password("123456")
                    .role(ADMIN)
                    .build();
            System.out.println("Admin Token: " + authenticationService.register(admin).getAccessToken());

            var manager = RegisterRequest.builder()
                    .firstName("Manager")
                    .lastName("Manager")
                    .email("Manager@gmail.com")
                    .password("123456")
                    .role(MANAGER)
                    .build();
            System.out.println("Manager Token: " + authenticationService.register(manager).getAccessToken());

            var user = RegisterRequest.builder()
                    .firstName("User")
                    .lastName("User")
                    .email("User@gmail.com")
                    .password("123456")
                    .role(USER)
                    .build();
            System.out.println("User Token: " + authenticationService.register(user).getAccessToken());

        };
    }
}