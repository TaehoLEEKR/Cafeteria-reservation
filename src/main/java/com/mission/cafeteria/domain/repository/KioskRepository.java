package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.kiosk;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface KioskRepository extends JpaRepository<kiosk, Long> {
    Optional<kiosk> findByMasterId(Long masterId);
}
