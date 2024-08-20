package com.owasplab.owsp.exception;

import java.util.List;

public class ErrorResponse {
    private int status;
    private List<String> errors;

    public ErrorResponse(int status, List<String> errors) {
        this.status = status;
        this.errors = errors;
    }

    // Getters and setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }
}
