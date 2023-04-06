package com.example.student_course.service.impl;

import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;
import com.example.student_course.mapper.StudentMapper;
import com.example.student_course.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    //个人信息操作
    @Override
    public Student selectStudent(Integer sid) {
        return studentMapper.selectStudent(sid);
    }

    @Override
    public void updateStudent(Student student) {
        studentMapper.UpdateStudent(student);
    }

    @Override
    public Classes selectClass(Integer sid) {
        return studentMapper.selectClass(sid);
    }

    @Override
    public Teacher selectCourse(String cname) {
        return studentMapper.selectCourse(cname);
    }

    @Override
    public String insertCheck(Student student) {
        try{
            studentMapper.insertCheck(student);
            return "true";
        }catch(Exception e){
            return e+"";
        }
    }

    @Override
    public Integer selectState(Integer sid) {
        try{
            return studentMapper.selectState(sid);
        }catch(Exception e){
            System.out.println(111111111);
            return 1;
        }
    }

    @Override
    public Integer selectcheck(Integer studentid) {
        try{
            return studentMapper.selectcheck(studentid);
        }catch(Exception e){
            return 1;
        }
    }

    @Override
    public void deleteCheck(Integer sid) {
        studentMapper.deleteCheck(sid);
    }

    @Override
    public String addtemp(Student student) {
        try{
            studentMapper.addtemp(student);
            return "true";
        }catch(Exception e){
            return e+"";
        }
    }
}
