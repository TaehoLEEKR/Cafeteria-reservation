package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.form.SignInForm;
import com.mission.cafeteria.domain.model.Customer;
import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.CustomerService;
import com.mission.cafeteria.service.PartnerService;

import com.mission.common.userType;
import com.mission.config.JwtAuthenticationProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignInApplication {
    private final CustomerService customerService;
    private final PartnerService partnerService;
    private final JwtAuthenticationProvider provider;

    public String customerLoginToken(SignInForm form){
        Customer customer = customerService.findValidCustomer(form.getEmail(), form.getPassword())
                .orElseThrow(() -> new PartnerException(ErrorCode.LOGIN_CHECK_FAIL));

        return provider.createToken(customer.getEmail(), customer.getId(), userType.CUSTOMER);
    }

    public String partnerLoginToken(SignInForm form){
        Partner partner = partnerService.findVaildPartner(form.getEmail(), form.getPassword()).orElseThrow(
                ()->new PartnerException(ErrorCode.LOGIN_CHECK_FAIL));

        return provider.createToken(partner.getEmail(),partner.getId(),userType.PARTNER);

    }

}
