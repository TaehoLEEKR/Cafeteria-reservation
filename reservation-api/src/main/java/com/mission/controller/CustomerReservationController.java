package com.mission.controller;

import com.mission.application.ReservationApplication;
import com.mission.config.JwtAuthenticationProvider;
import com.mission.domain.AddReservation.AddReservationForm;
import com.mission.domain.Redis.Reservation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer/reservation")
@RequiredArgsConstructor
public class CustomerReservationController {
    private final ReservationApplication reservationApplication;
    private final JwtAuthenticationProvider provider;

    @PostMapping
    public ResponseEntity<Reservation> ReservationCafe(
            @RequestHeader(name ="X-AUTH-TOKEN") String token,
            @RequestBody AddReservationForm form){
        return ResponseEntity.ok(reservationApplication.reservationCafe(provider.getUserVo(token).getId(),form));
    }
}
