package com.onoffmix.yonsei.domain.domain.user.professor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Major {

    private Long id;
    private String name;
    private String engName;
    private String abbreviation;
    private MajorCategory category;

    protected Major() {}

    public static Major from(String name) {
        return new Major(null, name, null, null, null);
    }
}
