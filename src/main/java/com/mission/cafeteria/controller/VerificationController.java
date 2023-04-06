package com.mission.cafeteria.controller;

import com.mission.cafeteria.application.VerificationApplication;
import com.mission.cafeteria.domain.VerificationForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/verify")
@RequiredArgsConstructor
public class VerificationController {

    private final VerificationApplication verificationApplication;
    @PostMapping("/partner")
    public ResponseEntity<String> VerificationPartner(@RequestBody VerificationForm form){
        return ResponseEntity.ok(verificationApplication.partnerRegiste(form));
    }
    @GetMapping("/partner/verify")
    public ResponseEntity<String> verifyPartner(String email, String code){
        verificationApplication.partnerVerify(email,code);
        return ResponseEntity.ok("인증이 완료되었습니다.");
    }
}
