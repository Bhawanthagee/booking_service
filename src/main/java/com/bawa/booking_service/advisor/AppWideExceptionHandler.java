package com.bawa.booking_service.advisor;

import com.bawa.booking_service.dto.res.StandardResponse;
import com.bawa.booking_service.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class AppWideExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<StandardResponse> UserNotFoundException(UserNotFoundException ex) {
        return new ResponseEntity<>(
                new StandardResponse("User not found", ex.getMessage()),
                HttpStatus.NOT_FOUND
        );
    }

}
