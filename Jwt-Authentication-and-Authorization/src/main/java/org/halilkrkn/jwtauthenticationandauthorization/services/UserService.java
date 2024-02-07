package org.halilkrkn.jwtauthenticationandauthorization.services;

import lombok.RequiredArgsConstructor;
import org.halilkrkn.jwtauthenticationandauthorization.repository.UserRepository;
import org.halilkrkn.jwtauthenticationandauthorization.user.ChangePasswordRequest;
import org.halilkrkn.jwtauthenticationandauthorization.user.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@RequiredArgsConstructor
public class UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    public void changePassword(ChangePasswordRequest changePasswordRequest, Principal connectedUser) {
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        // check if the current password is not correct
        if (!passwordEncoder.matches(changePasswordRequest.getCurrentPassword(), user.getPassword())) {
            throw new RuntimeException("Current password is not correct");
        }

        // check if the new password and confirm password are not the same
        if (!changePasswordRequest.getNewPassword().equals(changePasswordRequest.getConfirmPassword())) {
            throw new RuntimeException("New password and confirm password are not the same");
        }

        // check if the new password is the same as the current password
        if (passwordEncoder.matches(changePasswordRequest.getNewPassword(), user.getPassword())) {
            throw new RuntimeException("New password cannot be the same as the current password");
        }

        // change the password
        user.setPassword(passwordEncoder.encode(changePasswordRequest.getNewPassword()));
        // save the user new password
        userRepository.save(user);

    }
}
