package com.sunflowers.authentication.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor // Required by JPA
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String email;

    @ElementCollection(fetch = FetchType.EAGER)
    private Set<String> roles; // Multiple roles (e.g., ["ROLE_USER", "ROLE_ADMIN"])

    /**
     * Constructor for UserDetails mapping.
     */
    public User(String username, String password, Set<String> roles) {
        this.username = username;
        this.password = password;
        this.roles = roles;
    }

    /**
     * Returns a collection of authorities (roles) for the user.
     */
    public Collection<? extends GrantedAuthority> getRoles() {
        return roles.stream()
                .map(SimpleGrantedAuthority::new) // Convert role strings into GrantedAuthority objects
                .collect(Collectors.toList());
    }
}
