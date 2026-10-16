package com.chmnu.ki_step.security.user_management.exception;

import lombok.Getter;

@Getter
public class UserGeneralException extends RuntimeException {

    private final Integer status;

    public UserGeneralException(Integer status) {
        this.status = status;
    }

    public UserGeneralException(String message, Integer status) {
        super(message);
        this.status = status;
    }

    public UserGeneralException(Throwable cause, Integer status) {
        super(cause);
        this.status = status;
    }
}
