package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.form.ReservationForm;
import com.mission.cafeteria.domain.model.Customer;
import com.mission.cafeteria.domain.model.Reservation;
import com.mission.cafeteria.domain.repository.CafeRepository;
import com.mission.cafeteria.domain.repository.CustomerRepository;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import com.mission.cafeteria.domain.repository.ReservationRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationServiace {
    private final PartnerRepository partnerRepository;
    private final CafeRepository cafeRepository;
    private final ReservationRepository reservationRepository;
    private final CustomerRepository customerRepository;

    //예약 등록

    public Reservation ReservationCafe(ReservationForm form){
        return reservationRepository.save(Reservation.from(form));
    }
    public boolean isCustomerVerify(String email){ // 고객이 이메일 인증을 받았는지 체크
        Customer customer =  customerRepository.findByEmail(email).orElseThrow(
                () -> new PartnerException(ErrorCode.NOT_FOUND_User)
        );
        if(!customer.isCustomer_verify()){
            throw new PartnerException(ErrorCode.CHECK_EMAIL_VERIFY);
        }else{
            return true;
        }
    }
    // 중복 예약 체크
    public boolean isCustomerCheck(String email){
        List<String> emailCnt =  reservationRepository.findByEmail(email).
    }
}
