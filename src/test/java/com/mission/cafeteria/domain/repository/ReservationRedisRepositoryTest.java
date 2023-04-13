package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.redis.Reservation;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.mission.cafeteria.domain.form.ReservationForm;

import java.time.LocalDateTime;


//@SpringBootTest
//class ReservationRedisRepositoryTest {
//
//    @Autowired
//    private ReservationRedisRepository reservationRedisRepository;
//
//    @Test
//    void ReservationRedisTest(){
//        //given
//        Reservation reservation = new Reservation(1L, 1,LocalDateTime.now(),true,"name","phone","email");
//
//        reservationRedisRepository.save(reservation);
//        //when
//        reservationRedisRepository.findById(reservation.getRes_id());
//        //then
//        reservationRedisRepository.count();
//        //삭제
//        reservationRedisRepository.delete(reservation);
//    }
//
//}