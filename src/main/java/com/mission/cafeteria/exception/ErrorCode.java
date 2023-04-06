package com.mission.cafeteria.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@RequiredArgsConstructor
@Getter
public enum ErrorCode {

    ALREADY_VERIFY(HttpStatus.BAD_REQUEST,"이미 인증이 완료 되었습니다."),
    NOT_FOUND_PARTNER(HttpStatus.BAD_REQUEST,"파트너가 없습니다."),
    WRONG_VERIFICATION(HttpStatus.BAD_REQUEST,"잘못된 인증입니다."),
    EXPIRE_CODE(HttpStatus.BAD_REQUEST,"인증이 만료되었습니다.");
    private final HttpStatus httpStatus;
    private final String detail;
}
