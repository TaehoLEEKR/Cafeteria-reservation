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
        Restaurant restaurant = new Restaurant();
        restaurant.setRes_id(1L);
        restaurant.setCname("test");
        restaurant.setEmail("testEmail");
        restaurant.setRes_time(LocalDateTime.now());
        rr.save(restaurant);
        rr.findById(restaurant.getRes_id());
        rr.count();
        //rr.delete(restaurant);
    }
}