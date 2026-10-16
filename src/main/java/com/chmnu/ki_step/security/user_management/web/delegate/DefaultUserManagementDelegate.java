package com.chmnu.ki_step.security.user_management.web.delegate;

import com.chmnu.ki_step.security.user_management.exception.UserNotFoundException;
import com.chmnu.ki_step.security.user_management.mapper.UserMapper;
import com.chmnu.ki_step.security.user_management.persistence.repository.UserRepository;
import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DefaultUserManagementDelegate implements UserManagementDelegate {

    private final UserRepository userRepository;

    private final UserMapper userMapper;

    @Transactional
    @Override
    public UserApiDTO create(UserApiDTO source) {
        var entity = userMapper.mapTo(source);

        entity.setId(null);

        entity = userRepository.save(entity);

        return userMapper.mapFrom(entity);
    }

    @Transactional
    @Override
    public UserApiDTO update(Long id, UserApiDTO source) {
        return userRepository.findById(id)
                .map(entity -> userMapper.mergeMapTo(source, entity))
                .map(userMapper::mapFrom)
                .orElseThrow(UserNotFoundException::new);
    }

    @Transactional(readOnly = true)
    @Override
    public UserApiDTO getById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapFrom)
                .orElseThrow(UserNotFoundException::new);
    }
}
