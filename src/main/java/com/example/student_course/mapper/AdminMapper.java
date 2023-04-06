package com.example.student_course.mapper;

import com.example.student_course.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
public interface AdminMapper {
    //管理员对用户登录表的四种增删改查
    List<User> selectList();

    User selectUser(Integer id);

    int delUser(Integer account);

    void insertUser(User user);

    int Update(User user);
    //管理员对课程表的四种增删改查

    List<Course> selectListCourse();

    Course selectCourse(Integer cid);

    int delCourse(Integer cid);

    void insertCourse(Course course);

    void UpdateCourse(Course course);

    //管理员对教师表单的操作
    List<Teacher> selectListTeacher();

    void insertTecher(Teacher teacher);

    void delTeacher(Integer tid);

    Teacher selectTeacher(Integer tid);

    void UpdateTeacher(Teacher teacher);

    //管理员对班级表单的操作
    List<Classes> selectListClasses();

    Classes getClassesCourse(Integer classid);

    void insertClasses(Classes classes);

    int delClasses(Integer classid);

    Classes selectClasses(Integer classid);

    void UpdateClasses(Classes classes);

    //管理员对教师表单的操作
    List<Student> selectListStudent();

    void insertStudent(Student student);

    void delStudent(Integer tid);

    Student selectStudent(Integer tid);

    void UpdateStudent(Student student);

    //模糊查询学生
    List<Student> findAllStudent(Student student);

    List<Teacher> findAllTea(Teacher teacher);

    List<Course> findAllCou(Course course);

    List<User> findAllUser(User user);

}
