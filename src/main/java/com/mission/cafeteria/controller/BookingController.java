package com.mission.cafeteria.controller;

import com.mission.cafeteria.application.BookingApplication;
import com.mission.cafeteria.domain.model.Cafe;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/booking")
@RequiredArgsConstructor
public class BookingController {
    private final BookingApplication bookingApplication;
    private final CafeRepository cafeRepository;

    @PostMapping("/customer")
    public ResponseEntity<String> ReservationCustomer(@RequestBody Restaurant form){
        return ResponseEntity.ok(bookingApplication.cafeBooking(form));
    }
    @GetMapping("/customer/bookinglist")
    public ResponseEntity<String> ReservationCheckPartner(){
        List<Cafe> cafeList = cafeRepository.findAll();

        return ResponseEntity.ok(cafeList.size() == 0 ? null :
                cafeList.stream().map(cafe -> cafe.getCname()).collect(Collectors.toList()).toString());
        // 등록된 매장을 전체 출력을 하는데 등록된 매장이 존재 하지않으면 null 아니면 전체 매장 조회
    }

    // 파트너 점장이 해당 매장을 예약현황을 확인
    @GetMapping("/partner/bookinglist")
    public ResponseEntity<String> ReservationCustomerList(
            int masterId
    ){
        return ResponseEntity.ok(bookingApplication.checkCafeBooking(masterId).toString());
    }

    @PostMapping("/partner/bookingverify")
    public ResponseEntity<String> ReservationVerifyCustomer(int masterId ,Long resId,boolean chk){
        return ResponseEntity.ok(bookingApplication.VerifyBookingCustomer(masterId , resId , chk));
    }
}
