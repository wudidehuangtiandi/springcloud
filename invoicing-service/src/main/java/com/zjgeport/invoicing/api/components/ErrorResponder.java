package com.zjgeport.invoicing.api.components;

import com.zjgeport.invoicing.domain.models.Error;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

@ControllerAdvice
public class ErrorResponder {

    @ExceptionHandler
    public ResponseEntity<Error> handleException(ResponseStatusException ex) {
        var error = new Error();
        error.message = ex.getReason();
        return ResponseEntity.status(ex.getStatus())
                .header(HttpHeaders.CACHE_CONTROL,"no-cache,no-store")
                .body(error);
    }

}
