package com.onoffmix.yonsei.controller.v1.user;

import com.onoffmix.yonsei.controller.v1.dto.user.UserSignUpDto;
import com.onoffmix.yonsei.controller.v1.dto.user.UserSignUpDto.InsiderRequest;
import com.onoffmix.yonsei.controller.v1.dto.user.UserSignUpDto.ProfessorRequest;
import com.onoffmix.yonsei.controller.v1.dto.user.UserSignUpDto.StudentRequest;
import com.onoffmix.yonsei.domain.domain.user.User;
import com.onoffmix.yonsei.domain.service.user.SignUpService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static com.onoffmix.yonsei.controller.v1.dto.user.UserSignUpDto.*;

@Tag(name = "사용자 - 회원가입")
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
@RestController
public class UserSignUpController {

    final private SignUpService signUpService;

    @PostMapping("/professor")
    public ResponseEntity<Response> createProfessor(@RequestBody @Valid ProfessorRequest request) {
        User user = signUpService.createProfessor(request.toDomain(), request.getMajorName());

        return ResponseEntity.ok().body(Response.from(user));
    }

    @PostMapping("/student")
    public ResponseEntity<Response> createStudent(@RequestBody @Valid StudentRequest request) {
        User user = signUpService.createStudent(request.toDomain(), request.getStudentNumber(), request.getGrade());

        return ResponseEntity.ok().body(Response.from(user));
    }

    @PostMapping("/insider")
    public ResponseEntity<Response> createInsider(@RequestBody @Valid InsiderRequest request) {
        User user = signUpService.createInsider(request.toDomain(), request.getDivision(), request.getEmployeeNumber());

        return ResponseEntity.ok().body(Response.from(user));
    }

    @PostMapping("/outsider")
    public ResponseEntity<Response> createOutsider(@RequestBody @Valid OutsiderRequest request) {
        User user = signUpService.createOutsider(request.toDomain(), request.getDivision());

        return ResponseEntity.ok().body(Response.from(user));
    }

    @PostMapping("/dispatch-outsider")
    public ResponseEntity<Response> createDispatchOutsider(@RequestBody @Valid DispatchOutsiderRequest request) {
        User user = signUpService.createDispatchOutsider(request.toDomain(), request.getDivision());

        return ResponseEntity.ok().body(Response.from(user));
    }
}