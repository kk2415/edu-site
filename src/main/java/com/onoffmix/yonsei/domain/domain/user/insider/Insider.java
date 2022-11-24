package com.onoffmix.yonsei.domain.domain.user.insider;

import com.onoffmix.yonsei.domain.entity.user.UserStatus;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import com.onoffmix.yonsei.domain.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Insider extends User {

    private String division;
    private String employeeNumber;

    protected Insider() {}

    private Insider(
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

    public static Insider of(
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
        return new Insider(email, name, password, birthday, subEmail, phone, status, lastLoginAt, isExpired, role, division, employeeNumber);
    }
}
