package com.mission.cafeteria.domain;


import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class RestaurantTest {
    @Autowired
    private ReservationRepository rr;


    @Test
    void RedisTest(){
//        Restaurant restaurant = new Restaurant();
//        restaurant.setRes_id(1L);
//        restaurant.setCname("test");
//        restaurant.setEmail("testEmail");
//        restaurant.setRes_time(LocalDateTime.now());
//        rr.save(restaurant);
//        rr.findById(restaurant.getRes_id());
//        rr.count();
//        //rr.delete(restaurant);
    }

    @Test
    void RedisBuilderTest(){
        // 예약 정보
        Restaurant restaurant = null;
        for (int i = 0; i <5 ; i++) {
            restaurant = Restaurant.builder()
                    .resid(1L*i)
                    .cname("TEST"+i)
                    .cafeid(i)
                    .email("TEST"+i)
                    .phone("0000"+i)
                    .reststatus(false)
                    .restime(LocalDateTime.of(2023,i+1,i+1,10,i+1))
                    .count(i)
                    .build();
        rr.save(restaurant);
        }
        restaurant = Restaurant.builder()
                .cname("TEST")
                .resid(1L*1)
                .cafeid(1)
                .email("TEST")
                .phone("1111")
                .reststatus(true)
                .restime(LocalDateTime.of(2023,1,1,10,1))
                .count(1)
                .build();
        // 새로운 예약 정보
        rr.save(restaurant);
        rr.count();

    }

}