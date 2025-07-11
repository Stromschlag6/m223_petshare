package com.petshare.petshare_api.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.util.Collections;
import java.util.List;

@Entity
public class ApplicationUser implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Setter
    private String username;
    @Setter
    private String password;

    public ApplicationUser() {} // WICHTIG: no-arg Constructor für JPA

    public ApplicationUser(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Standard-Getter & Setter ...

    // Methoden von UserDetails
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // keine Rollen für jetzt
    }

    @Override
    public boolean isAccountNonExpired() { return true; }

    @Override
    public boolean isAccountNonLocked() { return true; }

    @Override
    public boolean isCredentialsNonExpired() { return true; }

    @Override
    public boolean isEnabled() { return true; }

    @Override
    public String getUsername() { return username; }

    @Override
    public String getPassword() { return password; }

}
