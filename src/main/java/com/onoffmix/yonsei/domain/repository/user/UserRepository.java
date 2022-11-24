package com.onoffmix.yonsei.domain.repository.user;

import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
