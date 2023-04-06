package com.example.student_course.mapper;

import com.example.student_course.domain.Checks;
import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TeacherMapper {
    //教师查询个人信息
    Teacher selectTeacher(Integer tid);

    void UpdateTeacher(Teacher teacher);

    Classes selectClasses(String cname);

    List<Checks> selectChecks(Integer teacherid);

    Checks selectCheck(Integer checkid);

    void insertHistory(Checks checks);

    void YesChecks(Integer checkid);

    void deleChecks(Integer checkid);

    List<Checks> selectCheckes(Integer teacherid);

    Integer selectstudentid(Integer checkid);

    void updateChecks(Integer studentid);

    void delHistory(Integer studentid);

    List<Student> selectStudent(Integer classid);

    void Begintemp(Integer classid);

    void Endtemp();

    void delChecks(Integer classid);
}
