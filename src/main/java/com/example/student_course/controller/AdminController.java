package com.example.student_course.controller;


import com.alibaba.fastjson.JSONObject;
import com.example.student_course.domain.*;
import com.example.student_course.service.AdminService;
import com.example.student_course.unil.MD5Utils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    @Autowired
    private AdminService adminService;

    //查询用户登录表的所有数据
    @RequestMapping("/getIndex")
    public String getIndex(){
        return "index";
    }
    //查询用户登录表的所有数据
    @RequestMapping("/getAllUser")
    public String getAllUser(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<User> admin = adminService.findList();
        PageInfo<User> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "user_findAll";
    }

    //转到用户修改表
    @RequestMapping("/getUser/{account}")
    public String getUser(@PathVariable("account") Integer id,Model model){
        User user = adminService.findtUser(id);
        model.addAttribute("update",user);
        return "user_update";
    }

    //修改用户登录表中的某一个用户信息
    @PostMapping("/updateUser/{account}")
    public String updateUser(User user){
        user.setAccount(user.getAccount());
        user.setPassword1(MD5Utils.code(String.valueOf(user.getPassword1())));
        adminService.updateUser(user);
        return "redirect:/admin/getAllUser";
    }

    //查询课程表的所有数据
    @RequestMapping("/getAllCourse")
    public String getAllCourse(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Course> admin = adminService.selectListCourse();
        PageInfo<Course> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_cou_findAll";
    }

    //cid
    @RequestMapping("/getCourse/{cid}")
    public String getCourse(@PathVariable("cid") Integer id,Model model){
        Course course = adminService.selectCourse(id);
        model.addAttribute("update",course);
        return "admin_cou_update";
    }

    //删除课程表表中的某一个用户
    @RequestMapping("/delCourse/{cid}")
    public String delCourse(@PathVariable("cid") Integer cid,Model model){
        model.addAttribute("num",adminService.delCourse(cid));
        return "redirect:/admin/getAllCourse";
    }

    //在课程表表中添加一个课程

    @RequestMapping("/addsCourse")
    public String addsCourse(){
        return "admin_cou_insert";
    }

    @PostMapping("/addCourse")
    public String addCourse(Course course){
        adminService.insertCourse(course);
        return "redirect:/admin/getAllCourse";
    }

    //修改课程表表中的某一个课程信息
    @PostMapping("/updateCourse/{cid}")
    public String updateUser(Course course){
        adminService.updateCourse(course);
        return "redirect:/admin/getAllCourse";
    }

    //查询所有教师
    @RequestMapping("/getAllTeacher")
    public String getAllTeacher(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Teacher> admin = adminService.selectListTeacher();
        PageInfo<Teacher> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_tea_findAll";
    }

    @RequestMapping("/addsTeacher")
    public String addsTeacher(){
        return "admin_tea_insert";
    }

    @PostMapping("/addTeacher")
    public String addTeacher(Teacher teacher,User user){
        user.setAccount(teacher.getTid());
        user.setPassword1(MD5Utils.code(String.valueOf(teacher.getTpwd())));
        user.setType1("教师");
        adminService.insertTeacher(teacher,user);
        return "redirect:/admin/getAllTeacher";
    }

    @RequestMapping("/delTeacher/{tid}")
    public String delTeacher(@PathVariable("tid") Integer tid){
        adminService.delTeacher(tid);
        return "redirect:/admin/getAllTeacher";
    }

    @RequestMapping("/getTeacher/{tid}")
    public String getTeacher(@PathVariable("tid") Integer id,Model model){
        Teacher teacher = adminService.selectTeacher(id);
        model.addAttribute("update",teacher);
        return "admin_tea_update";
    }
    //修改教师表中的某一个信息
    @PostMapping("/updateTeacher/{tid}")
    public String updateTeacher(Teacher teacher){
        adminService.updateTeacher(teacher);
        return "redirect:/admin/getAllTeacher";
    }

    //查询所有班级
    @RequestMapping("/getAllClasses")
    public String getAllClasses(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Classes> admin = adminService.selectListClasses();
        PageInfo<Classes> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_cs_findAll";
    }

    @RequestMapping("/getClassesCourse/{classid}")
    public String getClassesCourse(Model model,@PathVariable("classid") Integer classid){
        Classes admin = adminService.getClassesCourse(classid);
        model.addAttribute("admin",admin);
        return "admin_cs_findCourse";
    }

    @RequestMapping("/addsClasses")
    public String addsClasses(){
        return "admin_cs_insert";
    }

    @PostMapping("/addClasses")
    public String addClasses(Classes classes){
        adminService.insertClasses(classes);
        return "redirect:/admin/getAllClasses";
    }

    @RequestMapping("/delClasses/{tid}")
    public String delClasses(@PathVariable("tid") Integer tid,Model model){
        model.addAttribute("num",adminService.delClasses(tid));
        return "redirect:/admin/getAllClasses";
    }

    @RequestMapping("/getClasses/{classid}")
    public String getClasses(@PathVariable("classid") Integer id,Model model){
        Classes classes = adminService.selectClasses(id);
        model.addAttribute("update",classes);
        return "admin_cs_update";
    }

    //修改班级表中的某一个信息
    @PostMapping("/updateClasses/{tid}")
    public String updateClasses(Classes classes){
        adminService.updateClasses(classes);
        return "redirect:/admin/getAllClasses";
    }

    //查询所有学生
    @RequestMapping("/getAllStudent")
    public String getAllStudent(Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum){
        PageHelper.startPage(pageNum,10);
        List<Student> admin = adminService.selectListStudent();
        PageInfo<Student> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_stu_findAll";
    }

    @RequestMapping("/addsStudent")
    public String addsStudent(){
        return "admin_stu_insert";
    }

    @PostMapping("/addStudent")
    public String addStudent(Student student,User user){
        user.setAccount(student.getSid());
        user.setPassword1(MD5Utils.code(String.valueOf(student.getSpwd())));
        user.setType1("学生");
        adminService.insertStudent(student,user);
        return "redirect:/admin/getAllStudent";
    }

    @RequestMapping("/delStudent/{sid}")
    public String delStudent(@PathVariable("sid") Integer sid){
        adminService.delStudent(sid);
        return "redirect:/admin/getAllStudent";
    }

    @RequestMapping("/getStudent/{tid}")
    public String getStudent(@PathVariable("tid") Integer id,Model model){
        Student student = adminService.selectStudent(id);
        model.addAttribute("update",student);
        return "admin_stu_update";
    }

    //修改教师表中的某一个信息
    @PostMapping("/updateStudent/{tid}")
    public String updateStudent(Student student){
        adminService.updateStudent(student);
        return "redirect:/admin/getAllStudent";
    }


    //模糊查询学生
    @RequestMapping("/student/findAll")
    public String findAllStudent(Student student,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("stuName") String stuName,@RequestParam(defaultValue = "1",value = "stuId") Integer stuId,@RequestParam("major") String major){
        PageHelper.startPage(pageNum,10);
        student.setSid(stuId);
        student.setSname(stuName);
        student.setSmajor(major);
        List<Student> admin = adminService.findAllStudent(student);
        PageInfo<Student> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_stu_findAll";
    }
    //模糊查询教师
    @RequestMapping("/student/findAllTea")
    public String findAllTea(Teacher teacher,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("teaName") String teaName,@RequestParam(defaultValue = "1",value = "teaId") Integer teaId){
        PageHelper.startPage(pageNum,10);
        teacher.setTid(teaId);
        teacher.setTname(teaName);
        List<Teacher> admin = adminService.findAllTea(teacher);
        PageInfo<Teacher> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_tea_findAll";
    }
    //模糊查询课程
    @RequestMapping("/course/findAll")
    public String findAllCou(Course course,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("couName") String couName,@RequestParam(defaultValue = "1",value = "couId") Integer couId){
        PageHelper.startPage(pageNum,10);
        course.setCid(couId);
        course.setCname(couName);
        List<Course> admin = adminService.findAllCou(course);
        PageInfo<Course> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_cou_findAll";
    }

    //模糊查询课程
    @RequestMapping("/user/findAll")
    public String findAllUser(User user,Model model, @RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum,@RequestParam("loginUserRole") String loginUserRole,@RequestParam(defaultValue = "1",value = "userId") Integer userId){
        PageHelper.startPage(pageNum,10);
        user.setAccount(userId);
        user.setType1(loginUserRole);
        List<User> admin = adminService.findAllUser(user);
        PageInfo<User> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        return "admin_cou_findAll";
    }
}
