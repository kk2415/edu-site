package com.onoffmix.yonsei.domain.domain.user.student;

import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import com.onoffmix.yonsei.domain.entity.user.student.Grade;
import com.onoffmix.yonsei.domain.domain.user.User;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
public class Student extends User {

    private String studentNumber;
    private Grade grade;

    protected Student() {}

    private Student(
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
            String studentNumber,
            Grade grade)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, tag);
        this.studentNumber = studentNumber;
        this.grade = grade;
    }
}
