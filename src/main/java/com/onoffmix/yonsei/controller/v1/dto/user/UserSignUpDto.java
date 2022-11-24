package com.onoffmix.yonsei.controller.v1.dto.user;

import com.onoffmix.yonsei.domain.entity.user.role.Role;
import com.onoffmix.yonsei.domain.entity.user.student.Grade;
import com.onoffmix.yonsei.domain.domain.user.User;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

public class UserSignUpDto {

    @Getter
    @NoArgsConstructor(access = AccessLevel.PROTECTED)
    public static class userRequest {

        @NotNull @NotBlank
        protected String email;

        @NotNull @NotBlank
        protected String name;

        @NotNull
        protected LocalDate birthday;

        @NotNull @NotBlank
        protected String password;

        @NotNull @NotBlank
        protected String subEmail;

        @NotNull @NotBlank
        protected String phone;

        protected List<String> tag;

        protected User toDomain(Role role) {
            return User.of(email, name, password, birthday, subEmail, phone, role, tag);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class ProfessorRequest extends userRequest {

        @NotNull @NotBlank
        private String majorName;

        public User toDomain() {
            return toDomain(Role.PROFESSOR);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class StudentRequest extends userRequest {

        @NotNull @NotBlank
        private String studentNumber;

        @NotNull
        private Grade grade;

        public User toDomain() {
            return toDomain(Role.STUDENT);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class InsiderRequest extends userRequest {

        @NotNull @NotBlank
        private String division;

        @NotNull @NotBlank
        private String employeeNumber;

        public User toDomain() {
            return toDomain(Role.INSIDER);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class OutsiderRequest extends userRequest {

        @NotNull @NotBlank
        private String division;

        public User toDomain() {
            return toDomain(Role.OUTSIDER);
        }
    }

    @Getter
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class DispatchOutsiderRequest extends userRequest {

        @NotNull @NotBlank
        private String division;

        public User toDomain() {
            return toDomain(Role.DISPATCH_OUTSIDER);
        }
    }

    @Getter
    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    @NoArgsConstructor(access = AccessLevel.PRIVATE)
    public static class Response {

        private String email;
        private String name;

        public static Response from(User user) {
            return new Response(user.getEmail(), user.getName());
        }
    }
}
