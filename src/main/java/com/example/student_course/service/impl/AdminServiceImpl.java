package com.example.student_course.service.impl;

import com.example.student_course.domain.*;
import com.example.student_course.mapper.AdminMapper;
import com.example.student_course.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    //对用户登录表单的四种增删改查
    @Override
    public List<User> findList() {
        return adminMapper.selectList();
    }

    @Override
    public User findtUser(Integer account) {
        return adminMapper.selectUser(account);
    }

    @Override
    public int removeUser(Integer account) {
        return adminMapper.delUser(account);
    }

    @Override
    public void updateUser(User user) {
        adminMapper.Update(user);
    }

    //对课程信息表的增删改查

    @Override
    public List<Course> selectListCourse() {
        return adminMapper.selectListCourse();
    }

    @Override
    public Course selectCourse(Integer cid) {
        return adminMapper.selectCourse(cid);
    }

    @Override
    public int delCourse(Integer cid) {
        return adminMapper.delCourse(cid);
    }

    @Override
    public void insertCourse(Course course) {
        adminMapper.insertCourse(course);
    }

    @Override
    public void updateCourse(Course course) {
        adminMapper.UpdateCourse(course);
    }

    //对教师表操作
    @Override
    public List<Teacher> selectListTeacher() {
        return adminMapper.selectListTeacher();
    }

    @Transactional
    @Override
    public void insertTeacher(Teacher teacher,User user) {
        adminMapper.insertUser(user);
        adminMapper.insertTecher(teacher);
    }

    @Transactional
    @Override
    public void delTeacher(Integer tid) {
        adminMapper.delUser(tid);
        adminMapper.delTeacher(tid);
    }

    @Override
    public Teacher selectTeacher(Integer tid) {
        return adminMapper.selectTeacher(tid);
    }

    @Override
    public void updateTeacher(Teacher teacher) {
        adminMapper.UpdateTeacher(teacher);
    }

    //班级表操作
    @Override
    public List<Classes> selectListClasses() {
        return adminMapper.selectListClasses();
    }

    @Override
    public Classes getClassesCourse(Integer classid) {
        return adminMapper.getClassesCourse(classid);
    }

    @Override
    public void insertClasses(Classes classes) {
        adminMapper.insertClasses(classes);
    }

    @Override
    public int delClasses(Integer classid) {
        return adminMapper.delClasses(classid);
    }

    @Override
    public Classes selectClasses(Integer classid) {
        return adminMapper.selectClasses(classid);
    }

    @Override
    public void updateClasses(Classes classes) {
        adminMapper.UpdateClasses(classes);
    }

    @Override
    public List<Student> selectListStudent() {
        return adminMapper.selectListStudent();
    }

    @Transactional
    @Override
    public void insertStudent(Student student,User user) {
        adminMapper.insertUser(user);
        adminMapper.insertStudent(student);
    }

    @Transactional
    @Override
    public void delStudent(Integer sid) {
        adminMapper.delUser(sid);
        adminMapper.delStudent(sid);
    }

    @Override
    public Student selectStudent(Integer sid) {
        return adminMapper.selectStudent(sid);
    }

    @Override
    public void updateStudent(Student student) {
        adminMapper.UpdateStudent(student);
    }

    @Override
    public List<Student> findAllStudent(Student student) {
        return adminMapper.findAllStudent(student);
    }

    @Override
    public List<Teacher> findAllTea(Teacher teacher) {
        return adminMapper.findAllTea(teacher);
    }

    @Override
    public List<Course> findAllCou(Course course) {
        return adminMapper.findAllCou(course);
    }

    @Override
    public List<User> findAllUser(User user) {
        return adminMapper.findAllUser(user);
    }
}
