package com.chmnu.ki_step.security.user_management.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DictionaryApiDTO {

    @NotNull
    private Integer id;

    private String name;
}
