package com.mission.cafeteria.domain.model.redisRepository;


import com.mission.cafeteria.domain.model.redis.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

    public interface ReservationRepository extends CrudRepository<Restaurant,Long> {
    //Optional<Restaurant> findRestaurantByRestime(LocalDateTime ldt);
    List<Restaurant> findByCafeid(int masterId);
    Restaurant findByCafeidAndResid(int masterId, Long resId);

    Restaurant findByEmailAndPhone(String email , String phone);
    Optional<Restaurant> findByPhoneAndResstatus(String phone , boolean status);





}
