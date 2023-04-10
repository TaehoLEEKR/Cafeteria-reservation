package com.mission.cafeteria.controller;

import com.mission.cafeteria.domain.form.ReservationForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationApplication reservationApplication;
    @PostMapping
    public ResponseEntity<String> ReservationCafe(@RequestBody ReservationForm form){
        return ResponseEntity.ok()
    }
}
