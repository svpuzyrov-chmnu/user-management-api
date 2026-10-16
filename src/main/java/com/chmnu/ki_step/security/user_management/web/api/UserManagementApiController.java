package com.chmnu.ki_step.security.user_management.web.api;

import com.chmnu.ki_step.security.user_management.web.delegate.UserManagementDelegate;
import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/user-management")
@RequiredArgsConstructor
public class UserManagementApiController implements UserManagementApi {

    private final UserManagementDelegate delegate;

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @Override
    public UserApiDTO create(@RequestBody @Valid UserApiDTO source) {
        return delegate.create(source);
    }

    @PutMapping(value = "/{id}")
    @Override
    public UserApiDTO update(@PathVariable(name = "id") Long id, @RequestBody @Valid UserApiDTO source) {
        return delegate.update(id, source);
    }

    @GetMapping(value = "/{id}")
    @Override
    public UserApiDTO getById(Long id) {
        return delegate.getById(id);
    }
}
