package com.chmnu.ki_step.security.user_management.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends UserGeneralException {

    public UserNotFoundException() {
        super(404);
    }

    public UserNotFoundException(String message) {
        super(message, 404);
    }

    public UserNotFoundException(Throwable cause) {
        super(cause, 404);
    }
}
