package com.mission.cafeteria.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PartnerException extends RuntimeException{
    private final ErrorCode errorCode;



    public PartnerException(ErrorCode errorCode){
        super(errorCode.getDetail());
        this.errorCode=errorCode;
    }

}
