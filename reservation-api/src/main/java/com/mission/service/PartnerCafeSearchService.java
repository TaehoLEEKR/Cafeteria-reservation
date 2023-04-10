package com.mission.service;

import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.domain.PartnerCafe;
import com.mission.domain.Repository.PartnerCafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PartnerCafeSearchService {

    private final PartnerCafeRepository partnerCafeRepository;

    public List<PartnerCafe> searchByName(String name){
        return partnerCafeRepository.searchByName(name);
    }
    public PartnerCafe getByPartnerCafeId(Long PartnerId){
        return partnerCafeRepository.findWithPartnerCafeItemsById(PartnerId).orElseThrow(()->new PartnerException(ErrorCode.NOT_FOUND_CAFE));
    }

}
