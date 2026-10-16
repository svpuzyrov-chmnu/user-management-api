package com.chmnu.ki_step.security.user_management.web.delegate;

import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;

public interface UserManagementDelegate {

    UserApiDTO create(UserApiDTO source);

    UserApiDTO update(Long id, UserApiDTO source);

    UserApiDTO getById(Long id);
}
