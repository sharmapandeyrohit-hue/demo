package com.school2skill.demo.runner;

import com.school2skill.demo.entity.Student;
import com.school2skill.demo.entity.Teacher;
import com.school2skill.demo.repository.StudentRepository;
import com.school2skill.demo.repository.TeacherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public DataLoader(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        List<Student> students=studentRepository.findAll();
        List<Teacher> teachers=teacherRepository.findAll();

        for(Student s:students){
            System.out.println("student Id is "+s.getId()+" whose name is "+s.getName());
        }

        for(Teacher t:teachers){
            System.out.println("Teacher Id "+t.getId()+" whose name is "+t.getName()+ " and teaches "+t.getSubject());
        }
    }
}
