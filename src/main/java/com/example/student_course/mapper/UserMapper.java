package com.example.student_course.mapper;

import com.example.student_course.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    User findByUname(Integer account); //通过用户名uname查找用户，注意要按照JPA的格式使用驼峰命名法
    User findByUnameAndPassword(Integer account, String password1);//通过用户名uname和密码查找用户

    User save(User user);

}