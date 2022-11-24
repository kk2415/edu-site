package com.onoffmix.yonsei.domain.domain.user.professor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class MajorCategory {

    private Long id;
    protected String name;

    protected MajorCategory() {}
}
