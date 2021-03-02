package com.zjgeport.invoicing.api.utils;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.function.Supplier;

public final class Errors {

    public static ResponseStatusException notFound() {
        return new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    public static Supplier<ResponseStatusException> notFound(String reason) {
        return () -> new ResponseStatusException(HttpStatus.NOT_FOUND, reason);
    }


    private Errors() {}

}
