package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.form.ReservationForm;
import com.mission.cafeteria.service.ReservationServiace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationApplication {
    private final ReservationServiace reservationServiace;

    public boolean CustomerVerify(String email){
        return reservationServiace.isCustomerVerify(email);
    }
    public String ReservationCafe(ReservationForm form){

    }
}
