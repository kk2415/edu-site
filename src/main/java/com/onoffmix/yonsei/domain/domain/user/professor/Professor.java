package com.onoffmix.yonsei.domain.domain.user.professor;

import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import com.onoffmix.yonsei.domain.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Professor extends User {

    private Major major;

    protected Professor() {}

    private Professor(
            String email,
            String name,
            String password,
            LocalDate birthday,
            String subEmail,
            String phone,
            UserStatus status,
            LocalDateTime lastLoginAt,
            boolean isExpired,
            Role role,
            List<String> tag,
            Major major)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, tag);
        this.major = major;
    }
}
