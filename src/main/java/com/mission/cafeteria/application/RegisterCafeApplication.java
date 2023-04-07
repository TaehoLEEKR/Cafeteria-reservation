package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.form.RegisteCafeForm;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.RegisterCafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RegisterCafeApplication {
    private final RegisterCafeService registerCafeService;

    public boolean CafeVerify(String email) { // 매장의 점주가 파트너인지 여부
        return registerCafeService.verifyCafe(email);
    }

    public String CafeRegiste(RegisteCafeForm form) { // 매장 등록 기능

        if (registerCafeService.isCafeExist(form.getEmail())) { // 매장이 이미 존재 하는지 체크
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
