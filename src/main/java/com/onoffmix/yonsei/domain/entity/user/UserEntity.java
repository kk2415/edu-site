package com.onoffmix.yonsei.domain.entity.user;

import com.onoffmix.yonsei.domain.entity.tag.UserTagEntity;
import com.onoffmix.yonsei.domain.entity.user.role.Role;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Table(name = "`user`")
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private LocalDate birthday;

    @Column(nullable = false)
    private String subEmail;

    @Column(nullable = false)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status = UserStatus.WAIT;

    @Column
    private LocalDateTime lastLoginAt;

    @Column
    private boolean isExpired;

    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<UserTagEntity> userTags = new ArrayList<>();

    protected UserEntity() {}

    public void addTags(List<String> userTag) {
        userTag.forEach(this::addTag);
    }

    public void addTag(String tag) {
        this.userTags.add(UserTagEntity.of(tag, this));
    }
}
