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
import java.time.format.DateTimeFormatter;


@Data
@Getter
@Builder
@RedisHash(value = "reservation",timeToLive = 6000)
public class Restaurant {
    @Id
    @Indexed
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long resid;

    private int cafeid; // 매장 id
    private LocalDateTime restime ; // 매장 예약 시간

    @Indexed
    private boolean resstatus; // 매장 예약 상태
    @Indexed
    private String cname; // 매장 이름

    @Indexed
    private String address;

    @Indexed
    private String phone; // 고객 번호

    @Indexed
    private String email; // 고객 이메일
    private int count ;

}
