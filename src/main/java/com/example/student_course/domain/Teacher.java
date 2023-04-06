package com.example.student_course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Setter
@Getter
@Accessors(chain = true)
public class Teacher {
    /*
    教师编号
     */
    private Integer tid;
    /*
        教师名称
     */
    private String tname;
    /*
        教师性别
     */
    private String tsex;
    /*
        教师课程1
     */
    @TableField(exist = false)
    private String cname;

    @TableField(exist = false)
    private Integer cleave;

    @TableField(exist = false)
    private Course course;

    private Integer classid;

    @TableField(exist = false)
    private String classname;

    @TableField(exist = false)
    private Classes classes;

    private Integer tpwd;
}
