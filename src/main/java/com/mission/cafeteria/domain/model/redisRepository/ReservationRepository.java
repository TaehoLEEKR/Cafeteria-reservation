package com.mission.cafeteria.domain.model.redisRepository;


import com.mission.cafeteria.domain.model.redis.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Restaurant,Long> {
}
