package com.petshare.petshare_api.controller;

import com.petshare.petshare_api.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {

    private List<User> users = List.of(
            new User(1L, "Anna", "anna@example.com"),
            new User(2L, "Ben", "ben@example.com")
    );

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return ResponseEntity.ok("Benutzer registriert (statisch)");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Map<String, String> data) {
        return ResponseEntity.ok("Login erfolgreich (statisch)");
    }
}
