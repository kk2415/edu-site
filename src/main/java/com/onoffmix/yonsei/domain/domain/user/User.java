package com.onoffmix.yonsei.domain.domain.user;

import com.onoffmix.yonsei.domain.entity.tag.UserTagEntity;
import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.insider.InsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.outsider.DispatchOutsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.outsider.OutsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.professor.MajorEntity;
import com.onoffmix.yonsei.domain.entity.user.professor.ProfessorEntity;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import com.onoffmix.yonsei.domain.entity.user.student.Grade;
import com.onoffmix.yonsei.domain.entity.user.student.StudentEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    public static UserStatus defaultUserStatus = UserStatus.WAIT;

    private Long id;
    private String email;
    private String name;
    private String password;
    private LocalDate birthday;
    private String subEmail;
    private String phone;
    private UserStatus status;
    private LocalDateTime lastLoginAt;
    private boolean isExpired;
    private Role role;
    List<String> tag;

    protected User() {}

    public static User of(
            String email,
            String name,
            String password,
            LocalDate birthday,
            String subEmail,
            String phone,
            Role role,
            List<String> tag) {
        return new User(null, email, name, password, birthday, subEmail, phone, defaultUserStatus, LocalDateTime.now(), false, role, tag);
    }

    public ProfessorEntity toProfessorEntity
            (MajorEntity majorEntity) {
        return ProfessorEntity.of(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, majorEntity);
    }

    public StudentEntity toStudentEntity(String studentNumber, Grade grade) {
        return StudentEntity.of(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, studentNumber, grade);
    }

    public InsiderEntity toInsiderEntity(String division, String employeeNumber) {
        return InsiderEntity.of(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division, employeeNumber);
    }

    public OutsiderEntity toOutsiderEntity(String division) {
        return OutsiderEntity.of(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division);
    }

    public DispatchOutsiderEntity toDispatchOutsiderEntity(String division) {
        return DispatchOutsiderEntity.of(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division);
    }

    public static User from(UserEntity userEntity) {
        return new User(
                userEntity.getId(),
                userEntity.getEmail(),
                userEntity.getName(),
                userEntity.getPassword(),
                userEntity.getBirthday(),
                userEntity.getSubEmail(),
                userEntity.getPhone(),
                userEntity.getStatus(),
                userEntity.getLastLoginAt(),
                userEntity.isExpired(),
                userEntity.getRole(),
                userEntity.getUserTags().stream().map(UserTagEntity::getTag).toList());
    }
}
