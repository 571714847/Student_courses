package com.example.student_course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@Setter
@Getter
@Accessors(chain = true)
public class Student {
    /*
    学生编号
     */
    private Integer sid;
    /*
        学生名称
     */
    private String sname;
    /*
        学生性别
     */
    private String ssex;
    /*
        学生班级1
     */
    private int classid;

    @TableField(exist = false)
    private String classname;

    @TableField(exist = false)
    private Classes classes;
    /*
    学生专业
 */
    private String smajor;
    /*
    学生卡号
 */
    private Integer cardid;
    /*
    学生缺勤次数
 */
    private Integer leavenum;
    /*
    学生电话
 */
    private String phone;
/*
请假状态
 */
    private String state;
/*
请假次数
 */
    private Integer statenum;

    @TableField(exist = false)
    private List<Checks> users;

    private Integer spwd;
}
