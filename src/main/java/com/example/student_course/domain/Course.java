package com.example.student_course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Course implements Serializable {

    /*
            课程id
             */
    private Integer cid;
    /*
    kec名称
     */
    private String cname;
    /*
    课程学分
     */
    private Integer cleave;

    @TableField(exist = false)
    private List<Teacher> users;
}
