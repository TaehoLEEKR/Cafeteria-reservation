package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.RegisteCafeForm;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.RegisterCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCafeApplication {
    private final RegisterCafeService registerCafeService;

    public boolean CafeVerify(String email) {
        return registerCafeService.verifyCafe(email);
    }

    public String CafeRegiste(RegisteCafeForm form) {

        if (registerCafeService.isCafeExist(form.getEmail())) {
            throw new PartnerException(ErrorCode.ALREADY_REGISTER_CAFE);
        } else {
            if (CafeVerify(form.getEmail())) {
                registerCafeService.RegisterCafe(form);
                return "매장 등록에 성공하였습니다.";
            } else {
                return "이메일 인증이 실패했습니다.";
            }
        }

    }
}
