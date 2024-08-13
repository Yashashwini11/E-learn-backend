package com.usecase.elearn.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth/")
@CrossOrigin(origins = "*") // Allow the frontend origin
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService service;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(service.register(request));
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @DeleteMapping("/logout")
    public ResponseEntity<?> logout(@AuthenticationPrincipal UserDetails userDetails) {
        System.out.println("Logout Functionality Called");
        service.logout(userDetails.getUsername());
        return ResponseEntity.ok().build();
    }
}
