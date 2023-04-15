package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe ,Long> {
    Optional<Cafe> findByEmail(String email);
    List<Cafe> findCafeByCname(String cname);

}
