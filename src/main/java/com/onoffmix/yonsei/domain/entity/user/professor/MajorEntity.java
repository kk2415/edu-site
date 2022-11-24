package com.onoffmix.yonsei.domain.entity.user.professor;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import javax.persistence.*;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "medicine_major")
@Entity
public class MajorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicine_major_id")
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String engName;

    @Column
    private String abbreviation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "medicine_major_category_id")
    private MajorCategoryEntity category;

    protected MajorEntity() {}
}
