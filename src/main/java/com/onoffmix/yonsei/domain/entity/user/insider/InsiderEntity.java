package com.onoffmix.yonsei.domain.entity.user.insider;

import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@DiscriminatorValue("IN")
@Entity
public class InsiderEntity extends UserEntity {

    private String division;
    private String employeeNumber;

    protected InsiderEntity() {}

    private InsiderEntity(
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
            String division,
            String employeeNumber)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, new ArrayList<>());
        this.division = division;
        this.employeeNumber = employeeNumber;
    }

    public static InsiderEntity of(
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
            String division,
            String employeeNumber)
    {
        return new InsiderEntity(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division, employeeNumber);
    }
}
