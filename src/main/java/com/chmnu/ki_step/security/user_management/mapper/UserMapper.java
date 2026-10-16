package com.chmnu.ki_step.security.user_management.mapper;

import com.chmnu.ki_step.security.user_management.persistence.entity.User;
import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;


public interface UserMapper {


    User mapTo(UserApiDTO source);

    User mergeMapTo(UserApiDTO source, User target);

    UserApiDTO mapFrom(User source);
}
