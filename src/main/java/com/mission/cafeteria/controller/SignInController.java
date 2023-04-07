package com.mission.cafeteria.controller;

import com.mission.cafeteria.application.SignInApplication;
import com.mission.cafeteria.domain.form.SignInForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/signIn")
public class SignInController {
    private final SignInApplication signInApplication;

    @PostMapping("/customer")
    public ResponseEntity<String> signInCustomer(@RequestBody SignInForm form){
        return ResponseEntity.ok(signInApplication.customerLoginToken(form));
    }
    @PostMapping("/partner")
    public ResponseEntity<String> signInSeller(@RequestBody SignInForm form){
        return ResponseEntity.ok(signInApplication.partnerLoginToken(form));
    }
}
