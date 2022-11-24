package com.onoffmix.yonsei.domain.repository.user;

import com.onoffmix.yonsei.domain.entity.user.professor.MajorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MajorRepository extends JpaRepository<MajorEntity, Long> {

    Optional<MajorEntity> findByName(String name);
}
