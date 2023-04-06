package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.RegisteCafeForm;
import com.mission.cafeteria.domain.model.Cafe;
import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.domain.repository.CafeRepository;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegisterCafeService {

    private final PartnerRepository partnerRepository;
    private final CafeRepository cafeRepository;

    /* 카페등록 */
    public Cafe RegisterCafe(RegisteCafeForm form){
        return cafeRepository.save(Cafe.from(form));
    }
    // 이미 존재하는 카페인지 여부 체크
    public boolean isCafeExist(String email){
        return cafeRepository.findByEmail(email.toLowerCase(Locale.ROOT)).isPresent();
    }

    //매장등록시 점장이 파트너 권한이 있는지 여부 체크
    @Transactional
    public boolean verifyCafe(String email){ // 파트너 체크
        Partner partner = partnerRepository.findByEmail(email).orElseThrow(()-> new PartnerException(ErrorCode.NOT_FOUND_PARTNER));
        if(!partner.isVerify()){ //파트너 체크가 False
            throw new PartnerException(ErrorCode.CHECK_EMAIL_VERIFY);
        }else{
            return true;
        }
    }
}
