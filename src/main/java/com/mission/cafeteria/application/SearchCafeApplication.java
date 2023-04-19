package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.model.Cafe;
import com.mission.cafeteria.domain.repository.CafeRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SearchCafeApplication {
    private final CafeRepository cafeRepository;
    public List<Cafe> findAllCafeName(){
        List<Cafe> cafeList = cafeRepository.findAll();
        return cafeList;
    }
    public Optional<Cafe>  findByCnameAndId(String cname , Long id){
        Optional<Cafe> cafeFindDetail = cafeRepository.findByCnameAndId(cname, id);
        if (cafeFindDetail == null){
            throw new PartnerException(ErrorCode.NOT_FOUND_CAFE);
        }
        return cafeFindDetail;
    }
}
