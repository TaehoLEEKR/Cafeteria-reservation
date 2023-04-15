package com.mission.cafeteria.domain.model.redis;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Index;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.index.Indexed;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.time.LocalDateTime;


@Data
@Getter
@Builder
@RedisHash(value = "reservation",timeToLive = 6000)
public class Restaurant {
    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resid;


    @Indexed
    private int cafeid; // 매장 id
    private LocalDateTime restime; // 매장 예약 시간

    private boolean reststatus; // 매장 예약 상태

    private String cname; // 매장 이름

    private String phone; // 고객 번호

    private String email; // 고객 이메일
    private int count ;
}
