package com.chmnu.ki_step.security.user_management.persistence.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Table(schema = "dict", name = "user_state")
@Entity
@Getter
@Setter
public class UserState {

    @Id
    private Integer id;

    private String name;
}
