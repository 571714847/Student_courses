package com.example.student_course.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.List;

@Setter
@Getter
@ToString
@Accessors(chain = true)
public class Classes {
    /*
            班级id
             */
    private Integer classid;
    /*
    班级名称
     */
    private String classname;
    /*
    班级年段
     */
    private Integer grade;
    /*
    班级专业
     */
    private String major;
    /*
    班级周一12课程
     */
    private String mcourse1;
    /*
    班级周一34课程
     */
    private String mcourse2;
    /*
    班级周一56课程
     */
    private String mcourse3;
    /*
    班级周一78课程
     */
    private String mcourse4;
    /*
    班级周二12课程
     */
    private String tcourse1;
    /*
    班级周一34课程
     */
    private String tcourse2;
    /*
    班级周一56课程
     */
    private String tcourse3;
    /*
    班级周一78课程
     */
    private String tcourse4;
    /*
班级周三12课程
 */
    private String wcourse1;
    /*
    班级周一34课程
     */
    private String wcourse2;
    /*
    班级周一56课程
     */
    private String wcourse3;
    /*
    班级周一78课程
     */
    private String wcourse4;
    /*
班级周四12课程
 */
    private String thcourse1;
    /*
    班级周一34课程
     */
    private String thcourse2;
    /*
    班级周一56课程
     */
    private String thcourse3;
    /*
    班级周一78课程
     */
    private String thcourse4;
    /*
班级周五12课程
 */
    private String fcourse1;
    /*
    班级周一34课程
     */
    private String fcourse2;
    /*
    班级周一56课程
     */
    private String fcourse3;
    /*
    班级周一78课程
     */
    private String fcourse4;

    @TableField(exist = false)
    private List<Teacher> users;

    private String cname;
}
