package com.onoffmix.yonsei.domain.entity.user.outsider;

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
@DiscriminatorValue("OUT")
@Entity
public class OutsiderEntity extends UserEntity {

    private String division;

    protected OutsiderEntity() {}

    private OutsiderEntity(
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
            String division)
    {
        super(null, email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, new ArrayList<>());
        this.division = division;
    }

    public static OutsiderEntity of(
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
            String division)
    {
        return new OutsiderEntity(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division);
    }
}
