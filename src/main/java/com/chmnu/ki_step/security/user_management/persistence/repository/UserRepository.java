package com.chmnu.ki_step.security.user_management.persistence.repository;

import com.chmnu.ki_step.security.user_management.persistence.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
