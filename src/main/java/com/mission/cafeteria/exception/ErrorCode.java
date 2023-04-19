package com.mission.cafeteria.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ALREADY_VERIFY(HttpStatus.BAD_REQUEST,"이미 인증이 완료 되었습니다."),
    NOT_USE_CAFE(HttpStatus.BAD_REQUEST,"매장을 이용후 작성해 주세요"),
    NOT_HAVING_INFORMATION(HttpStatus.BAD_REQUEST,"Email && Phone 정보를 확인해주세요."),
    RESERVATION_NOT_ENOUGHT(HttpStatus.BAD_REQUEST,"예약 인원이 충분하지 않습니다."),
    NOT_VERIFY_BOOKING(HttpStatus.BAD_REQUEST,"예약이 승인되어있지 않습니다."),
    BOOKING_TIME_FAIL(HttpStatus.BAD_REQUEST,"예약 할 수 없는 시간입니다."),
    CHECK_EMAIL_VERIFY(HttpStatus.BAD_REQUEST,"이메일 인증을 확인해 주세요"),
    ALREADY_REGISTER_CAFE(HttpStatus.BAD_REQUEST,"이미 등록이 완료 된 카페입니다."),

    NOT_FOUND_PARTNER(HttpStatus.BAD_REQUEST,"파트너가 없습니다."),
    NOT_FOUND_CAFE(HttpStatus.BAD_REQUEST,"매장이 없습니다."),
    NOT_FOUND_User(HttpStatus.BAD_REQUEST,"고객이 없습니다."),
    WRONG_VERIFICATION(HttpStatus.BAD_REQUEST,"잘못된 인증입니다."),
    LOGIN_CHECK_FAIL(HttpStatus.BAD_REQUEST,"로그인에 실패하였습니다 ID/PW 를 확인해주시고 이메일 인증이 완료되었는지 확인해 주세요."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST,"인증이 만료되었습니다.");
    private final HttpStatus httpStatus;
    private final String detail;
}
