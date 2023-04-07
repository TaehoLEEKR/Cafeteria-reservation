package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.form.VerificationForm;
import com.mission.cafeteria.domain.model.Customer;
import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.domain.repository.CustomerRepository;
import com.mission.cafeteria.domain.repository.PartnerRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Locale;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class VerificationPartnerService {
    private final PartnerRepository partnerRepository;
    private final CustomerRepository customerRepository;
    public Partner VerificationSignup(VerificationForm form){
        return partnerRepository.save(Partner.from(form));
    }
    public boolean isEmailExist(String email){
        return partnerRepository.findByEmail(email.toLowerCase(Locale.ROOT)).isPresent();
    }
    @Transactional
    public void verifyEmail(String email, String code,String type){
        Partner partner = null;
        Customer customer = null;
        if(type == "partner"){
            partner = partnerRepository.findByEmail(email).orElseThrow(()-> new PartnerException(ErrorCode.NOT_FOUND_PARTNER));
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
        }else if(type =="customer"){
            customer = customerRepository.findByEmail(email).orElseThrow(()->new PartnerException(ErrorCode.NOT_FOUND_User));
            if(customer.isCustomer_verify()){
                throw new PartnerException(ErrorCode.ALREADY_VERIFY);
            }
            if(!customer.getVerificationCode().equals(code)){
                throw new PartnerException(ErrorCode.WRONG_VERIFICATION);
            }

            customer.setCustomer_verify(true);
        }
    }
    @Transactional
    public LocalDateTime ChangeCustomerValidateEmail(Long customerId , String code){
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
