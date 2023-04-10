package com.mission.cafeteria.domain.form;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class ReservationForm {
    private LocalDateTime res_time;
    private int c_id;
    private boolean reservation_status;

    private String cname;
    private String phone;

    private String email;
}
