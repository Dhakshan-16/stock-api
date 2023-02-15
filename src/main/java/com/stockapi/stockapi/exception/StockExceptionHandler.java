package com.stockapi.stockapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

@ControllerAdvice
public class StockExceptionHandler {
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity handleException(MaxUploadSizeExceededException e) {
        // log exception
        return ResponseEntity
                .status(HttpStatus.EXPECTATION_FAILED)
                .body("Error Message");
    }
}
