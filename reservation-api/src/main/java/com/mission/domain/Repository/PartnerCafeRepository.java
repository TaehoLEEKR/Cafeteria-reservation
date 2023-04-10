package com.mission.domain.Repository;


import com.mission.domain.PartnerCafe;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PartnerCafeRepository extends JpaRepository<PartnerCafe ,Long>,PartnerCafeRepositoryCustom {
    @EntityGraph(attributePaths = {"partnerCafeItems"},type = EntityGraph.EntityGraphType.LOAD)
    Optional<PartnerCafe> findWithPartnerCafeItemsById(Long id);

}
