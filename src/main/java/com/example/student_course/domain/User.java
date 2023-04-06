package com.example.student_course.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class User {
    /*account
    登录用户账号
     */
    private Integer account;
    /*account
    登录用户类型
     */
    private String type1;
    /*account
    登录用户密码
    */
    private String password1;
}
