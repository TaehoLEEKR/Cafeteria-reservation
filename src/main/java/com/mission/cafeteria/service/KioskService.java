package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.form.KioskForm;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class KioskService {

    private final ReservationRepository reservationRepository;
    public boolean checkIn(KioskForm form){
        // 파트너점장의 예약 확인이 되었는지 체크
        Restaurant restaurant = reservationRepository.findByEmailAndPhone(form.getEmail(), form.getPhone());
        if(!restaurant.isResstatus()){
            throw new PartnerException(ErrorCode.NOT_VERIFY_BOOKING);
        }
        // 예약 10분전에 도착 하였는지 체크
        LocalDateTime now = LocalDateTime.now();
        return true;
        // 키오스크를 통해 도착 확인

    }
}
