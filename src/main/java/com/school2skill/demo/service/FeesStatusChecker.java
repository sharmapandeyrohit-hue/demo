package com.school2skill.demo.service;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class FeesStatusChecker {
    public boolean isFeesPaid(Long studentId){
        return studentId == 1;
    }
}
