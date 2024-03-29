package org.halilkrkn.jwtauthenticationandauthorization.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Permission {

    // For Admin
    ADMIN_READ("admin:read"),
    ADMIN_CREATE("admin:write"),
    ADMIN_UPDATE("admin:update"),
    ADMIN_DELETE("admin:delete"),

    // For Manager
    MANAGER_READ("management:read"),
    MANAGER_CREATE("management:write"),
    MANAGER_UPDATE("management:update"),
    MANAGER_DELETE("management:delete")
    ;

     private final String permission;
}
