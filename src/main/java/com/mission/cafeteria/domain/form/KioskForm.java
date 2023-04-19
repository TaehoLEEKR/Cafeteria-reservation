package com.mission.cafeteria.domain.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KioskForm {
    private String email;
    private String phone;
    private boolean checkin = false;

}
