package com.chmnu.ki_step.security.user_management.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(schema = "core", name = "user")
@Entity
@Getter
@Setter
@SequenceGenerator(
        name = "USER_ID_GENERATOR",
        sequenceName = "core.user_id_seq",
        allocationSize = 1
)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USER_ID_GENERATOR")
    @Column(name = "id")
    private Long id;

    @Column(name = "login")
    private String login;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "password")
    private String password;

    @ManyToOne
    @JoinColumn(name = "state_id")
    private UserState state;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
