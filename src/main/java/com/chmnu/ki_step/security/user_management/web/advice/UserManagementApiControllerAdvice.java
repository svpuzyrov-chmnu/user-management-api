package com.chmnu.ki_step.security.user_management.web.advice;

import com.chmnu.ki_step.security.user_management.exception.UserGeneralException;
import com.chmnu.ki_step.security.user_management.web.api.UserManagementApiController;
import com.chmnu.ki_step.security.user_management.web.delegate.UserManagementExceptionDelegate;
import com.chmnu.ki_step.security.user_management.web.dto.ErrorApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = {UserManagementApiController.class})
@RequiredArgsConstructor
public class UserManagementApiControllerAdvice {

    private final UserManagementExceptionDelegate delegate;

    @ExceptionHandler(UserGeneralException.class)
    public ResponseEntity<ErrorApiDTO> handle(UserGeneralException exception) {
        var payload = delegate.handle(exception);
        return ResponseEntity.status(HttpStatus.valueOf(payload.getCode()))
                .body(payload);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorApiDTO> handle(Exception exception) {
        var payload = delegate.handle(exception);
        return ResponseEntity.status(HttpStatus.valueOf(payload.getCode()))
                .body(payload);
    }
}
