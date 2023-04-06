package com.example.student_course.service;

import com.example.student_course.domain.Checks;
import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;

import java.util.List;

public interface TeacherService {
    Teacher selectTeacher(Integer tid);

    void UpdateTeacher(Teacher teacher);

    Classes selectClasses(String cname);

    List<Checks> selectChecks(Integer teacherid);

    Checks selectCheck(Integer checkid);

    void YesChecks(Integer checkid,Checks checks);

    void deleChecks(Integer checkid);

    List<Checks> selectCheckes(Integer teacherid);

    void updateChecks(Integer checkid);

    List<Student> selectStudent(Integer classid);

    void Begintemp(Integer classid);

    void Endtemp(Integer classid);
}
