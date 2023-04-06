package com.example.student_course.service;

import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;

public interface StudentService {
    Student selectStudent(Integer sid);

    void updateStudent(Student student);

    Classes selectClass(Integer sid);

    Teacher selectCourse(String cname);

    String insertCheck(Student student);

    //查询是否正在请假期间
    Integer selectState(Integer sid);

    //查询是否已经提交请假
    Integer selectcheck(Integer studentid);

    void deleteCheck(Integer sid);

    String addtemp(Student student);
}
