 package com.mission.cafeteria.domain.repository;

import com.mission.cafeteria.domain.model.Partner;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PartnerRepository extends JpaRepository<Partner,Long> {
    Optional<Partner> findByEmail(String email);
    //Optional<Partner> findByEmailAndVerify(String email,boolean verify);

}
