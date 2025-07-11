package com.petshare.petshare_api.controller;

import com.petshare.petshare_api.entity.ApplicationUser;
import com.petshare.petshare_api.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private ApplicationUserRepository applicationUserRepository;

    @GetMapping
    public List<ApplicationUser> getAllUsers() {
        return applicationUserRepository.findAll();
    }

    @PostMapping
    public ApplicationUser createUser(@RequestBody ApplicationUser applicationUser) {
        return applicationUserRepository.save(applicationUser);
    }
}