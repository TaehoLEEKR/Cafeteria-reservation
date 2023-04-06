package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.VerificationForm;
import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.print.PrintException;
import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class VerificationPartnerService {
    private final PartnerRepository partnerRepository;

    public Partner VerificationSignup(VerificationForm form){
        return partnerRepository.save(Partner.from(form));
    }
    public boolean isEmailExist(String email){
        return partnerRepository.findByEmail(email.toLowerCase(Locale.ROOT)).isPresent();
    }
    @Transactional
    public void verifyEmail(String email, String code){
        Partner partner = partnerRepository.findByEmail(email).orElseThrow(()-> new PartnerException(ErrorCode.NOT_FOUND_PARTNER));
        if(partner.isVerify()){
            throw new PartnerException(ErrorCode.ALREADY_VERIFY);
        }
        if(!partner.getVerificationCode().equals(code)){
            throw new PartnerException(ErrorCode.WRONG_VERIFICATION);
        }
        if(partner.getVerificationDt().isBefore(LocalDateTime.now())){
            throw new PartnerException(ErrorCode.EXPIRE_CODE);
        }
        partner.setVerify(true);
    }
    @Transactional
    public LocalDateTime  ChangeCustomerValidateEmail(Long customerId , String code){
        Optional<Partner> customerOptional = partnerRepository.findById(customerId);
        if(customerOptional.isPresent()){
            Partner partner = customerOptional.get();
            partner.setVerificationCode(code);
            partner.setVerificationDt(LocalDateTime.now().plusDays(1));

            return partner.getVerificationDt();
        }
        throw new PartnerException(ErrorCode.NOT_FOUND_PARTNER);
    }
}
