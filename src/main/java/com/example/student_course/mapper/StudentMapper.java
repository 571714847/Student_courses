package com.example.student_course.mapper;

import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper {

    //学生查询个人信息
    Student selectStudent(Integer sid);

    void UpdateStudent(Student student);

    Classes selectClass(Integer sid);

    Teacher selectCourse(String cname);
    //请假
    void insertCheck(Student student);

    //查询是否正在请假期间
    Integer selectState(Integer sid);

    //查询是否已经提交请假
    Integer selectcheck(Integer studentid);

    void deleteCheck(Integer sid);

    void addtemp(Student student);
}
