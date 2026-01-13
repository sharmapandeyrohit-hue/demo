package com.school2skill.demo.service;

import com.school2skill.demo.entity.Teacher;
import com.school2skill.demo.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }
}
