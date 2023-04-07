package com.mission.cafeteria.domain.model;


import com.mission.cafeteria.domain.form.VerificationForm;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Partner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id; // id

    @Column(unique = true)
    private String email; // email

    private String master; // 점장 이름
    private  String password;
    private LocalDateTime verificationDt; // 파트너 승인 날짜

    private String verificationCode;
    private boolean verify; // 파트너 승인

    public static Partner from(VerificationForm form){
        return Partner.builder()
                .email(form.getEmail())
                .master(form.getMaster())
                .password(form.getPassword())
                .verificationDt(form.getVerificationDt())
                .verify(false)
                .build();
    }


}
