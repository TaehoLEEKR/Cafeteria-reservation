package com.mission.cafeteria.domain.model.redis;

import lombok.Data;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;


@Data
@Getter
@RedisHash(value = "reservaion")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long res_id;

    private int c_id; // 매장 id
    private LocalDateTime res_time; // 매장 예약 시간

    private boolean res_status = false; // 매장 예약 상태

    private String cname; // 매장 이름

    private String phone; // 고객 번호

    private String email; // 고객 이메일
}
