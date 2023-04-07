package com.mission.cafeteria.controller;

import com.mission.cafeteria.application.RegisterCafeApplication;
import com.mission.cafeteria.domain.form.RegisteCafeForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/register")
public class RegisteCafeController {
    private final RegisterCafeApplication registercafeApplication;

    @PostMapping("/cafe") // 매장 등록을 위한 컨트롤러
    public ResponseEntity<String> RegisterCafe(@RequestBody RegisteCafeForm form){
        return ResponseEntity.ok(registercafeApplication.CafeRegiste(form));
    }
}
