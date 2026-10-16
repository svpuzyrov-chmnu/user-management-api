package com.chmnu.ki_step.security.user_management.web.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class UserApiDTO {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("login")
    @NotEmpty
    private String login;

    @JsonProperty("password")
    @NotEmpty
    private String password;

    @JsonProperty("email")
    @NotEmpty
    @Email
    private String email;

    @JsonProperty("state")
    private DictionaryApiDTO state;

    @JsonProperty("created_at")
    private LocalDateTime createdAt;

    @JsonProperty("updated_at")
    private LocalDateTime updatedAt;
}
