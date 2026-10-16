package com.chmnu.ki_step.security.user_management.web.delegate;

import com.chmnu.ki_step.security.user_management.exception.UserGeneralException;
import com.chmnu.ki_step.security.user_management.web.dto.ErrorApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserManagementExceptionDelegateImpl implements UserManagementExceptionDelegate {

    @Override
    public ErrorApiDTO handle(UserGeneralException source) {
        return ErrorApiDTO.builder()
                .code(source.getStatus())
                .message(source.getMessage())
                .build();
    }

    @Override
    public ErrorApiDTO handle(Exception source) {
        return ErrorApiDTO.builder()
                .code(500)
                .message(source.getMessage())
                .build();
    }
}
