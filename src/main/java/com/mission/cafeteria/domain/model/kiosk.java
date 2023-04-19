package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.form.KioskForm;
import lombok.*;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class kiosk {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long masterId;
    private String description;
    private String address;
    private String cname;
    private String phone;
    private String email;
    private float rate;
    private boolean checkin = false;

    public static kiosk from(KioskForm form){
        return kiosk.builder()
                .phone(form.getPhone())
                .email(form.getEmail())
                .checkin(form.isCheckin())
                .build();
    }


}
