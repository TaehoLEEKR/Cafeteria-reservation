package com.mission.cafeteria.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice

public class ExceptionController {
    @ExceptionHandler({
            PartnerException.class

    })
    public ResponseEntity<ExceptionResponse> customRequestException(final PartnerException c){
        //log.warn("api Exception : {} ",c.getErrorCode() );
        return ResponseEntity.badRequest().body(new ExceptionResponse(c.getMessage(),c.getErrorCode()));
    }

    @Getter
    @ToString
    @AllArgsConstructor
    public static class ExceptionResponse{
        private String message;
        private ErrorCode errorCode;
    }
}
