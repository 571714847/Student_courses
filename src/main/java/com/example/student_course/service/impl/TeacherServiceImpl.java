package com.example.student_course.service.impl;

import com.example.student_course.domain.Checks;
import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;
import com.example.student_course.mapper.TeacherMapper;
import com.example.student_course.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherMapper teachermapper;

    @Override
    public Teacher selectTeacher(Integer tid) {
        return teachermapper.selectTeacher(tid);
    }

    @Override
    public void UpdateTeacher(Teacher teacher) {
        teachermapper.UpdateTeacher(teacher);
    }

    @Override
    public Classes selectClasses(String cname) {

        return teachermapper.selectClasses(cname);
    }

    @Override
    public List<Checks> selectChecks(Integer teacherid) {
        return teachermapper.selectChecks(teacherid);
    }

    @Override
    public Checks selectCheck(Integer checkid) {
        return teachermapper.selectCheck(checkid);
    }

    @Transactional
    @Override
    public void YesChecks(Integer checkid,Checks checks) {
        teachermapper.YesChecks(checkid);
        teachermapper.deleChecks(checkid);
        teachermapper.insertHistory(checks);
    }

    @Override
    public void deleChecks(Integer checkid) {
        teachermapper.deleChecks(checkid);
    }

    @Override
    public List<Checks> selectCheckes(Integer teacherid) {
        return teachermapper.selectCheckes(teacherid);
    }

    @Transactional
    @Override
    public void updateChecks(Integer checkid) {
        Integer studentid = teachermapper.selectstudentid(checkid);
        teachermapper.updateChecks(studentid);
        teachermapper.delHistory(studentid);
    }

    @Override
    public List<Student> selectStudent(Integer classid) {
        return teachermapper.selectStudent(classid);
    }

    @Transactional
    @Override
    public void Begintemp(Integer classid) {
        teachermapper.Begintemp(classid);
    }

    @Transactional
    @Override
    public void Endtemp(Integer classid) {
        teachermapper.Endtemp();
        teachermapper.delChecks(classid);
    }


}
