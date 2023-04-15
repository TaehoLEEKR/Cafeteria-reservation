package com.mission.cafeteria.service;

import com.mission.cafeteria.domain.model.Cafe;
import com.mission.cafeteria.domain.repository.CafeRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookingCustomerService {
    private final CafeRepository cafeRepository;

    // 매장이 존재 하는지 여부 체크
    // cafe 라는 테이블안에 -> 1,test,test,test,tset,0,0000
    // test 라는 매장을 예약 시 test가 있는지 존재여부
    public boolean isExistCafeBooking(String cname){
        List<Cafe> cafeList = cafeRepository.findCafeByCname(cname);
        if(cafeList.size() > 0){
            return true;
        }
        throw new PartnerException(ErrorCode.NOT_FOUND_CAFE);
    }



}
