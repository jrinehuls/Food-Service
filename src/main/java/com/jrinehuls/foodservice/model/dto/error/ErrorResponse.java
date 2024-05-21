package com.jrinehuls.foodservice.model.dto.error;

import java.util.List;
import java.util.Map;

public class ErrorResponse {

    private String message;
    private Map<String, List<String>> errors;

    public ErrorResponse(){}
    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse (String message, Map<String, List<String>> errors) {
        this.message = message;
        this.errors = errors;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

}
