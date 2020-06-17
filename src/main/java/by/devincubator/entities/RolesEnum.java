package by.devincubator.entities;

import org.springframework.security.core.GrantedAuthority;

public enum RolesEnum implements GrantedAuthority {
    ROLE_USER, ROLE_TUTOR, ROLE_ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
