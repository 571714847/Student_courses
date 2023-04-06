package com.example.student_course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Checks {
    private Integer checkid;

    private Integer teacherid;

    @TableField(exist = false)
    private String sname;

    @TableField(exist = false)
    private Student student;

    private Integer studentid;

    private Integer classid;

    private String cname;
}
