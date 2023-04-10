package com.mission.domain.AddReservation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AddReservationForm { // 매장 예약 정보
    private Long id;
    private Long cafe_id;
    private boolean res_status; // 매장 예약 상태

    private String cname; // 매장 이름

    private String phone; // 고객 번호

    private String email; // 고객 이메일

    List<AddReservationForm> items;
}
