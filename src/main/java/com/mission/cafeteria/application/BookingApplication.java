package com.mission.cafeteria.application;

import com.mission.cafeteria.domain.form.RegisteCafeForm;
import com.mission.cafeteria.domain.model.redis.Restaurant;
import com.mission.cafeteria.domain.model.redisRepository.ReservationRepository;
import com.mission.cafeteria.domain.repository.CafeRepository;
import com.mission.cafeteria.exception.ErrorCode;
import com.mission.cafeteria.exception.PartnerException;
import com.mission.cafeteria.service.BookingCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingApplication {
    private final BookingCustomerService bookingCustomerService;

    private final ReservationRepository reservationRepository;
    private final CafeRepository cafeRepository;
    // 매장 존재 여부 확인 (isExsitsCafe) v
    // 예약시 중복시간 체크 (CheckTimeBooking)
    // 예약 승인 받았는지 체크 (VerifyBookingCustomer) v
    // 매장 예약 (cafeBooking) v
    public boolean isExsitsCafe(String cname){
        return bookingCustomerService.isExistCafeBooking(cname);
    }
    public boolean checkTimeBooking(LocalDateTime ldt,String cname, String adr){
        List<Restaurant> restaurantList = new ArrayList<>();
        List<Restaurant> items = reservationRepository.findByCnameAndAddress(cname,adr);

        if(items.isEmpty()){
            return true;
        }
        for(Restaurant restaurant : items){
            restaurantList.add(restaurant);
        }
        for (int i = 0; i <restaurantList.size(); i++) {
            String date =restaurantList.get(i).getRestime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
            LocalDateTime dateTimeFormat = LocalDateTime.parse(date ,formatter);
            if(dateTimeFormat.isEqual(ldt)){
                return false;
            }else{
                return true;
            }
        }
        return false;
    }

    // 점주가 가지고있는 매장에 예약 리스트를 확인
    public List<Restaurant> checkCafeBooking(String cname, String adr){
        List<Restaurant> restaurant = reservationRepository.findByCnameAndAddress(cname,adr);
        return restaurant;
    }
    public String VerifyBookingCustomer(int cafeId, Long resId, boolean chk){
        Restaurant restaurant =
                reservationRepository.findByCafeidAndResid(cafeId,resId);
        if(chk == false){
            restaurant.setResstatus(chk);
            reservationRepository.save(restaurant);
            return "예약을 거절하였습니다.";
        }else{
            restaurant.setResstatus(chk);
            reservationRepository.save(restaurant);
        }

        return "예약이 승인되었습니다.";
    }
    public String cafeBooking(RegisteCafeForm form){


        String date =form.getRestime().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm"));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
        LocalDateTime dateTimeFormat = LocalDateTime.parse(date ,formatter);

        if(!isExsitsCafe(form.getCname())){ // 매장 이름으로 조사
            throw new PartnerException(ErrorCode.NOT_FOUND_CAFE);
        }else if(!checkTimeBooking(dateTimeFormat , form.getCname(), form.getAddress())){ // redis에 저장된 예약시간이 중복인지 체크
            throw new PartnerException(ErrorCode.BOOKING_TIME_FAIL);
        }else if(form.getEmail()== null && form.getPhone() == null){ // 예약 정보가 정상적이지 않을 경우
            throw new PartnerException(ErrorCode.NOT_HAVING_INFORMATION);
        }
        Restaurant restaurant =Restaurant.builder()
                .resid(1L)
                .cname(form.getCname())
                .email(form.getEmail())
                .phone(form.getPhone())
                .resstatus(false)
                .restime(dateTimeFormat)
                .count(form.getCount())
                .build();
        reservationRepository.save(restaurant);
        return "예약이 완료되었습니다. 키오스크를 통해 10분전에 예약을 완료해주세요.";
    }

}
