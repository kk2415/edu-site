package com.onoffmix.yonsei.domain.service.user;

import com.onoffmix.yonsei.domain.entity.user.insider.InsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.outsider.DispatchOutsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.outsider.OutsiderEntity;
import com.onoffmix.yonsei.domain.entity.user.professor.MajorEntity;
import com.onoffmix.yonsei.domain.entity.user.professor.ProfessorEntity;
import com.onoffmix.yonsei.domain.entity.user.student.Grade;
import com.onoffmix.yonsei.domain.entity.user.student.StudentEntity;
import com.onoffmix.yonsei.domain.domain.user.User;
import com.onoffmix.yonsei.domain.repository.user.MajorRepository;
import com.onoffmix.yonsei.domain.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Slf4j
@RequiredArgsConstructor
@Service
public class SignUpService {

    private final UserRepository userRepository;
    private final MajorRepository majorRepository;

    @Transactional
    public User createProfessor(User user, String majorName) {
        MajorEntity majorEntity = majorRepository.findByName(majorName)
                .orElseThrow(() -> new EntityNotFoundException("존재하지 않는 전공 과목입니다."));

        ProfessorEntity professor = user.toProfessorEntity(majorEntity);
        professor.addTags(user.getTag());

        userRepository.save(professor);

        return User.from(professor);
    }

    @Transactional
    public User createStudent(User user, String studentNumber, Grade grade) {
        StudentEntity student = user.toStudentEntity(studentNumber, grade);
        student.addTags(user.getTag());

        userRepository.save(student);

        return User.from(student);

    }

    @Transactional
    public User createInsider(User user, String division, String employeeNumber) {
        InsiderEntity insider = user.toInsiderEntity(division, employeeNumber);
        insider.addTags(user.getTag());

        userRepository.save(insider);

        return User.from(insider);

    }

    @Transactional
    public User createOutsider(User user, String division) {
        OutsiderEntity outsider = user.toOutsiderEntity(division);
        outsider.addTags(user.getTag());

        userRepository.save(outsider);

        return User.from(outsider);

    }

    @Transactional
    public User createDispatchOutsider(User user, String division) {
        DispatchOutsiderEntity outsider = user.toDispatchOutsiderEntity(division);
        outsider.addTags(user.getTag());

        userRepository.save(outsider);

        return User.from(outsider);
    }
}
