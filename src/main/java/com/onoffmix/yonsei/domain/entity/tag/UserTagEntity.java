package com.onoffmix.yonsei.domain.entity.tag;

import com.onoffmix.yonsei.domain.entity.user.UserEntity;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "user_tag")
@Entity
public class UserTagEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_tag_id")
    private Long id;

    @Column(nullable = false)
    private String tag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id")
    private UserEntity user;

    protected UserTagEntity() {}

    public static UserTagEntity of(String tag, UserEntity user) {
        return new UserTagEntity(null, tag, user);
    }
}
