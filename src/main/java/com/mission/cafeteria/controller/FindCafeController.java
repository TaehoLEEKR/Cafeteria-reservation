package com.mission.cafeteria.controller;

import com.mission.cafeteria.application.SearchCafeApplication;
import com.mission.cafeteria.domain.model.Cafe;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
@RequestMapping("/find")
public class FindCafeController {
    private final SearchCafeApplication searchCafeApplication;
    @GetMapping("/customer")
    ResponseEntity<List<Cafe>> findAllCafeName(){ // 예약할 매장 전체 확인
        return ResponseEntity.ok(searchCafeApplication.findAllCafeName());
    }
}
