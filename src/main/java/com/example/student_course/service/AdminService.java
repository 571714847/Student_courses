package com.example.student_course.service;

import com.example.student_course.domain.*;

import java.util.List;

public interface AdminService {
    //对用户登录表单的增删改查

    List<User> findList();

    User findtUser(Integer account);

    int removeUser(Integer account);

    void updateUser(User user);

    //对课程信息表的增删改查

    List<Course> selectListCourse();

    Course selectCourse(Integer cid);

    int delCourse(Integer cid);

    void insertCourse(Course course);

    void updateCourse(Course course);

    //对教师表的操作
    List<Teacher> selectListTeacher();

    void insertTeacher(Teacher teacher,User user);

    void delTeacher(Integer tid);

    Teacher selectTeacher(Integer tid);

    void updateTeacher(Teacher teacher);

    //对班级表的操作
    List<Classes> selectListClasses();

    Classes getClassesCourse(Integer classid);

    void insertClasses(Classes classes);

    int delClasses(Integer classid);

    Classes selectClasses(Integer classid);

    void updateClasses(Classes classes);

    //对学生表的操作
    List<Student> selectListStudent();

    void insertStudent(Student student,User user);

    void delStudent(Integer sid);

    Student selectStudent(Integer sid);

    void updateStudent(Student student);

    //模糊查询
    List<Student> findAllStudent(Student student);

    List<Teacher> findAllTea(Teacher teacher);

    List<Course> findAllCou(Course course);

    List<User> findAllUser(User user);
}
