package com.example.student_course;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.example.student_course.mapper")

public class StudentCourseApplication {
    public static void main(String[] args) {
        SpringApplication.run(StudentCourseApplication.class, args);
    }
}
