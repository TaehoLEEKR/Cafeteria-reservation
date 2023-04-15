package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PartnerService {
    private final PartnerRepository partnerRepository;
    private final ReservationRepository reservationRepository;
    public Optional<Partner> findByIdAndEmail(Long id, String email){
        return partnerRepository.findById(id).stream()
                .filter(partner -> partner.getEmail().equals(email)).findFirst();
    }
    public Optional<Partner> findVaildPartner(String email , String password){
        return partnerRepository.findByEmail(email).stream().filter(
                customer -> customer.getPassword().equals(password) && customer.isVerify()
        ).findFirst();
    }
//    @Transactional // 파트너점장이 예약 리스트 확인후 승인
//    //파트너가 승인 을 체크시 True 로 변환
//    public List<Restaurant> verifyPartnerBooking(Restaurant form){
//
//        return null;
//    }

}
