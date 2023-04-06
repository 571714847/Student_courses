package com.example.student_course.service;

import com.example.student_course.domain.User;

public interface UserService {
    /**
     * 登录业务逻辑
     * @param account 账户名
     * @param password1 密码
     * @return
     */
    User loginService(Integer account, String password1);

    /**
     * 注册业务逻辑
     * @param user 要注册的User对象，属性中主键uid要为空，若uid不为空可能会覆盖已存在的user
     * @return
     */
    User registService(User user);
}