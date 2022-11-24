package com.onoffmix.yonsei.domain.entity.user.professor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "medicine_major_category")
@Entity
public class MajorCategoryEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_major_category_id")
    private Long id;

    @Column(nullable = false)
    protected String name;

    protected MajorCategoryEntity() {}
}
