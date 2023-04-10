package com.mission.application;

import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.domain.AddReservation.AddReservationForm;
import com.mission.domain.PartnerCafe;
import com.mission.domain.Redis.Reservation;

import com.mission.service.PartnerCafeSearchService;
import com.mission.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationApplication {

    private final PartnerCafeSearchService partnerCafeSearchService;
    private final ReservationService reservationService;

    public Reservation reservationCafe(Long customerId, AddReservationForm form){
        PartnerCafe partnerCafe = partnerCafeSearchService.getByPartnerCafeId(form.getCafe_id());
        if(partnerCafe==null){
            throw new PartnerException(ErrorCode.NOT_FOUND_CAFE);
        }
        //Reservation reservation =
        //예약 서비스 구현
        return null;
    }

}
