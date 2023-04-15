package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.model.Cafe;
import com.mission.cafeteria.domain.repository.CafeRepository;
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
}
