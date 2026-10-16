package com.chmnu.ki_step.security.user_management.web.api;

import com.chmnu.ki_step.security.user_management.web.dto.UserApiDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "UserManagementApi")
public interface UserManagementApi {

    /**
     * POST /v1/user-management
     *
     * @param source - new user DTO
     * @return created user DTO
     */
    @Operation(method = "create", description = "Create new user")
    @ApiResponse(responseCode = "201", description = "Success create new user", ref = "UserApiDTO")
    @ApiResponse(responseCode = "400", description = "Cannot create new user", ref = "ErrorApiDTO")
    UserApiDTO create(UserApiDTO source);

    /**
     * PUT /v1/user-management/{id}
     *
     * @param source - new data for existing user DTO
     * @return updated user DTO
     */
    UserApiDTO update(Long id, UserApiDTO source);

    /**
     * GET /v1/user-management/{id}
     *
     * @param id - user id
     * @return existing user DTO
     */
    UserApiDTO getById(Long id);
}
