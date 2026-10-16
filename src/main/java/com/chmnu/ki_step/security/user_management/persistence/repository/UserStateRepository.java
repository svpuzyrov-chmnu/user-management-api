package com.chmnu.ki_step.security.user_management.persistence.repository;

import com.chmnu.ki_step.security.user_management.persistence.entity.UserState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserStateRepository extends JpaRepository<UserState, Integer> {
}
