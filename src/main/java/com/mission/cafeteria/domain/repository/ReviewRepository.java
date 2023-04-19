package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


public interface ReviewRepository extends JpaRepository<Review ,Long> {
    Optional<Review> findByPhone(String phone);
    Optional<Review> findByEmailAndPhone(String email, String phone);

    Optional<Review> findByCname(String cname);
}
