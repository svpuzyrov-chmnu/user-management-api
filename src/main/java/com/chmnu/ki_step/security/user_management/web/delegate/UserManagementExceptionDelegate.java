package com.chmnu.ki_step.security.user_management.web.delegate;

import com.chmnu.ki_step.security.user_management.exception.UserGeneralException;
import com.chmnu.ki_step.security.user_management.web.dto.ErrorApiDTO;

public interface UserManagementExceptionDelegate {

    ErrorApiDTO handle(UserGeneralException source);

    ErrorApiDTO handle(Exception source);

}
