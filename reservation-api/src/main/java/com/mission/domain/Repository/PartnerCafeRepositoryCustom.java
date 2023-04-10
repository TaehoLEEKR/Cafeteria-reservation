package com.mission.domain.Repository;



import com.mission.domain.PartnerCafe;

import java.util.List;

public interface PartnerCafeRepositoryCustom {
    List<PartnerCafe> searchByName(String name);
}
