package com.school2skill.demo.service;

import com.school2skill.demo.entity.Student;
import com.school2skill.demo.repository.StudentRepository;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
//    private final FeesStatusChecker feesStatusChecker;
//
//    public StudentService(StudentRepository studentRepository, FeesStatusChecker feesStatusChecker) {
//        this.studentRepository = studentRepository;
//        this.feesStatusChecker = feesStatusChecker;
//    }
    private final ObjectProvider<FeesStatusChecker> checkerProvider;

    public StudentService(StudentRepository studentRepository,
                          ObjectProvider<FeesStatusChecker> checkerProvider) {
        this.studentRepository = studentRepository;
        this.checkerProvider = checkerProvider;
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

//    public String viewMarksheet(Long studentId){
//        System.out.println(feesStatusChecker.hashCode());
//        boolean feesPaid= feesStatusChecker.isFeesPaid(studentId);
//
//        if (feesPaid){
//            return "Marksheet displayed for student id "+studentId;
//
//        }else {
//            return "Access Denied : Fees Not Paid";
//        }
//        }

    public String viewMarksheet(Long studentId) {

        // NEW instance fetched each time (if prototype)
        FeesStatusChecker checker = checkerProvider.getObject();
        System.out.println("FeesStatusChecker hashCode: " + checker.hashCode());

        boolean feesPaid = checker.isFeesPaid(studentId);

        if (feesPaid) {
            return "Marksheet displayed for student id " + studentId;
        } else {
            return "Access Denied : Fees Not Paid";
        }
    }
}
