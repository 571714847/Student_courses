package com.example.student_course.service.impl;

import com.example.student_course.domain.User;
import com.example.student_course.mapper.UserMapper;
import com.example.student_course.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service @Primary
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User loginService(Integer account, String password1) {
        // 如果账号密码都对则返回登录的用户对象，若有一个错误则返回null
        User user = userMapper.findByUnameAndPassword(account, password1);
        // 重要信息置空
        if(user != null){
            user.setPassword1("");
        }
        return user;
    }

    @Override
    public User registService(User user) {
        if(userMapper.findByUname(user.getAccount())!=null){
            // 无法注册
            return null;
        }else{
            //返回创建好的用户对象(带uid)
            User newUser = userMapper.save(user);
            if(newUser != null){
                newUser.setPassword1("");
            }
            return newUser;
        }
    }
}
