package org.halilkrkn.jwtauthenticationandauthorization.controllers;

import lombok.RequiredArgsConstructor;
import org.halilkrkn.jwtauthenticationandauthorization.services.UserService;
import org.halilkrkn.jwtauthenticationandauthorization.user.ChangePasswordRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PatchMapping
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequest changePasswordRequest, Principal connectedUser) {
        userService.changePassword(changePasswordRequest, connectedUser);
        return ResponseEntity.ok("Password changed successfully!");
    }


    @GetMapping
    public ResponseEntity<String> sayHello() {
        return ResponseEntity.ok("Hello from secured endpoint!");
    }

    @GetMapping("/hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("GET:: User Controller ,Hello from secured endpoint!");
    }

    @PostMapping
    public ResponseEntity<String> post() {
        return ResponseEntity.ok("POST:: User Controller");
    }

    @PutMapping
    public ResponseEntity<String> put() {
        return ResponseEntity.ok("PUT:: User Controller");
    }

    @DeleteMapping
    public ResponseEntity<String> delete() {
        return ResponseEntity.ok("DELETE:: User Controller");
    }
}
