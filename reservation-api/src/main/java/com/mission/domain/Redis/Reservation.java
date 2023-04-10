package com.mission.domain.Redis;

import com.mission.domain.AddReservation.AddReservationForm;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@RedisHash("Reservation")
public class Reservation {
    @Id
    private Long customer_id;

    private List<Reservation_Cafe> reservationCafeList = new ArrayList<>();

    public Reservation(Long customer_id){
        this.customer_id = customer_id;
    }
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Reservation_Cafe {
        private Long id;
        private Long cafe_id;
        private boolean res_status; // 매장 예약 상태

        private String cname; // 매장 이름

        private String phone; // 고객 번호

        private String email; // 고객 이메일

        public static Reservation_Cafe from(AddReservationForm form){
            return Reservation_Cafe.builder()
                    .id(form.getId())
                    .cafe_id(form.getCafe_id())
                    .cname(form.getCname())
                    .email(form.getEmail())
                    .build();
        }
    }
}
