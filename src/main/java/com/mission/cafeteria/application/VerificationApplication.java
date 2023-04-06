package com.mission.cafeteria.application;

import com.mission.cafeteria.client.MailgunClient;
import com.mission.cafeteria.client.mailgun.SendMailForm;
import com.mission.cafeteria.domain.VerificationForm;
import com.mission.cafeteria.domain.model.Partner;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.VerificationPartnerService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class VerificationApplication {
    private final VerificationPartnerService verificationPartnerService;
    private final MailgunClient mailgunClient;

    public void partnerVerify(String email ,String code){
        verificationPartnerService.verifyEmail(email,code);
    }
    public String partnerRegiste(VerificationForm form){
        if(verificationPartnerService.isEmailExist(form.getEmail())){
            throw new PartnerException(ErrorCode.ALREADY_VERIFY);
        }
        else{
            Partner partner = verificationPartnerService.VerificationSignup(form);
            String code = getRendomCode();

            SendMailForm  sendMailForm = SendMailForm.builder()
                    .from("679748@naver.com")
                    .to(form.getEmail())
                    .subjects("Verification Email")
                    .text(getVerificationEmailBody(form.getEmail(), form.getMaster(), "MASTER" ,code))
                    .build();
            mailgunClient.sendEmail(sendMailForm);
            verificationPartnerService.ChangeCustomerValidateEmail(partner.getId(),code);

            return "파트너 등록에 성공하였습니다.";
        }
    }

    private String getRendomCode() {
        return RandomStringUtils.random(10,true,true);
    }

    private String getVerificationEmailBody(String email ,String name ,String type,String code){
        StringBuilder builder = new StringBuilder();
        return builder.append("Hello").append(name).append("! Please Click Link for verificaiton.\n\n")
                .append("http://localhost:8081/partner/"+type+"/verify/?email=")
                .append(email)
                .append("&code")
                .append(code).toString();

    }
}
