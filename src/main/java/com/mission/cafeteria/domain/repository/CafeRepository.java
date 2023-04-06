package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.Cafe;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CafeRepository extends JpaRepository<Cafe ,Long> {
    Optional<Cafe> findByEmail(String email);
}
