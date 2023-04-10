package com.mission.cafeteria.domain.model;

import com.mission.cafeteria.domain.form.ReservationForm;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long res_id;

    private int c_id; // 매장 id
    private LocalDateTime res_time; // 매장 예약 시간

    private boolean res_status; // 매장 예약 상태

    private String cname; // 매장 이름

    private String phone; // 고객 번호

    private String email; // 고객 이메일


    public static Reservation from(ReservationForm form){
        return Reservation.builder()
                .cname(form.getCname())
                .c_id(form.getC_id())
                .res_status(false)
                .res_time(form.getRes_time())
                .phone(form.getPhone())
                .email(form.getEmail())
                .build();
    }
}
