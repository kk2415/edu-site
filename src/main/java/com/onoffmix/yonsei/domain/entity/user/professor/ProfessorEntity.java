package com.onoffmix.yonsei.domain.entity.user.professor;

import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@DiscriminatorValue("PRO")
@Entity
public class ProfessorEntity extends UserEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_major_id")
    private MajorEntity medicineMajor;

    protected ProfessorEntity() {}

    private ProfessorEntity(
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
            MajorEntity major)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, new ArrayList<>());
        this.medicineMajor = major;
    }

    public static ProfessorEntity of(
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
            MajorEntity major)
    {
        return new ProfessorEntity(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, major);
    }

    public static ProfessorEntity of(UserEntity user, MajorEntity major) {
        return new ProfessorEntity(
                user.getEmail(),
                user.getName(),
                user.getPassword(),
                user.getBirthday(),
                user.getSubEmail(),
                user.getPhone(),
                user.getStatus(),
                user.getLastLoginAt(),
                user.isExpired(),
                user.getRole(),
                major);
    }
}
