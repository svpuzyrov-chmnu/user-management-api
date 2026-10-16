package com.chmnu.ki_step.security.user_management.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ErrorApiDTO {

    private Integer code;

    private String message;
}
