package com.mission.cafeteria.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.time.LocalDateTime;
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class VerificationForm {
    private String email; // email
    private String master; // 점장 이름
    private String password;

    //  private LocalDateTime verificationDt; // 파트너 승인 날짜
//    private boolean verify; // 파트너 승인

}
