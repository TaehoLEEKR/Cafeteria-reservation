package com.mission.cafeteria.controller;

import com.mission.cafeteria.domain.form.KioskForm;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import com.mission.cafeteria.service.KioskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
@RequestMapping("/kiosk")
public class KioskController {
    private final KioskService kioskService;
    private final ReservationRepository reservationRepository;

    @GetMapping
    public ResponseEntity<Restaurant> showCafeInfo(@RequestParam String email , @RequestParam String phone)
    {
        return ResponseEntity.ok(reservationRepository.findByEmailAndPhone(email,phone));
    }
    @PostMapping
    public ResponseEntity<Boolean> checkInKiosk(@RequestBody KioskForm form){
        return ResponseEntity.ok(kioskService.checkIn(form));
    }
}
