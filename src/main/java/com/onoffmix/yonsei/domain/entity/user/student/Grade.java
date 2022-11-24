package com.onoffmix.yonsei.domain.entity.user.student;

public enum Grade {

    PreFreshMan("예과 1학년"),
    PreSophomore("예과 2학년"),

    MainFreshMan("본과 1학년"),
    MainSophomore("본과 2학년"),
    MainJunior("본과 3학년"),
    MainSenior("본과 4학년"),
    ;

    private String name;

    Grade(String name) {
        this.name = name;
    }
}
