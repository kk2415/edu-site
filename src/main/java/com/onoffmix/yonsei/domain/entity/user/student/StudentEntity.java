package com.onoffmix.yonsei.domain.entity.user.student;

import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@DiscriminatorValue("STU")
@Entity
public class StudentEntity extends UserEntity {

    private String studentNumber;
    private Grade grade;

    protected StudentEntity() {}

    private StudentEntity(
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
            String studentNumber,
            Grade grade)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, new ArrayList<>());
        this.studentNumber = studentNumber;
        this.grade = grade;
    }

    public static StudentEntity of(
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
            String studentNumber,
            Grade grade)
    {
        return new StudentEntity(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, studentNumber, grade);
    }
}
