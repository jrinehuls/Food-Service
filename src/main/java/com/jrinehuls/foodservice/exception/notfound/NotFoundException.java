package com.jrinehuls.foodservice.exception.notfound;

import com.jrinehuls.foodservice.exception.ApiException;
import org.springframework.http.HttpStatus;

public abstract class NotFoundException extends ApiException {

    public NotFoundException(String message) {
        super(message);
    }

    @Override
    public HttpStatus getStatusCode() {
        return HttpStatus.NOT_FOUND;
    }
}
