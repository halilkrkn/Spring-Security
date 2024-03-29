package org.halilkrkn.jwtauthenticationandauthorization.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.halilkrkn.jwtauthenticationandauthorization.user.Role;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Role role;
}
