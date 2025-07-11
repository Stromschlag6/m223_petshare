package com.petshare.petshare_api.service;

import com.petshare.petshare_api.dto.AuthResponseDTO;
import com.petshare.petshare_api.dto.LoginRequestDTO;
import com.petshare.petshare_api.dto.RegisterRequestDTO;
import com.petshare.petshare_api.entity.ApplicationUser;
import com.petshare.petshare_api.repository.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApplicationUserService {

    @Autowired
    private ApplicationUserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtService jwtService;

    public AuthResponseDTO registerUser(RegisterRequestDTO request) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        userRepository.save(user);

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }

    public AuthResponseDTO authenticateUser(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        ApplicationUser user = userRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        String token = jwtService.generateToken(user);
        return new AuthResponseDTO(token);
    }
}
