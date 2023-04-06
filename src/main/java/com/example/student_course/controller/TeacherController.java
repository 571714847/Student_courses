package com.example.student_course.controller;

import com.example.student_course.domain.*;
import com.example.student_course.service.TeacherService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/teacher")
@Slf4j
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @RequestMapping("/getIndex")
    public String getIndex(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Teacher teacher = teacherService.selectTeacher(account);
        model.addAttribute("teacher", teacher);
        return "tea_index";
    }
    //个人信息查询
    @RequestMapping("/getAllTeacher")
    public String getStudent(HttpServletRequest request, Model model) {
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Teacher teacher = teacherService.selectTeacher(account);
        model.addAttribute("teacher", teacher);
        return "tea_find";
    }

    @RequestMapping("/updatesTeacher")
    public String updatesTeacher(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Teacher teacher = teacherService.selectTeacher(account);
        model.addAttribute("update", teacher);
        return "tea_update";
    }

    @PostMapping("/updateTeacher/{tid}")
    public String updateTeacher(Teacher teacher, HttpServletRequest request) {
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        teacher.setTid(account);
        teacherService.UpdateTeacher(teacher);
        return "redirect:/teacher/getAllTeacher";
    }
    //查询课程班级
    @RequestMapping("/getClasses/{cname}")
    public String getCheck(HttpServletRequest request,Model model,@PathVariable("cname") String cname){
        request.getSession().setAttribute("cname",cname);
        Classes classes = teacherService.selectClasses(cname);
        if (classes == null){
            return "null";
        }else {
            model.addAttribute("admin",classes);
            return "tea_findCourse";
        }
    }
    //管理请假
    @RequestMapping("/getCheck")
    public String getCheck(HttpServletRequest request, Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        PageHelper.startPage(pageNum,10);
        List<Checks> admin = teacherService.selectChecks(account);
        PageInfo<Checks> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        if(admin.isEmpty()){
            return "null";
        }else{
            model.addAttribute("checks", admin);
            return "tea_check";
        }
    }
    //同意
    @RequestMapping("/YesChecks/{checkid}")
    public String YesChecks( @PathVariable("checkid") Integer checkid) {
        Checks checks = teacherService.selectCheck(checkid);
        teacherService.YesChecks(checkid,checks);
        return "redirect:/teacher/getCheck";
    }
    //拒绝
    @RequestMapping("/NoChecks/{checkid}")
    public String NoChecks(HttpServletRequest request, @PathVariable("checkid") Integer checkid) {
        request.getSession().setAttribute("checkid",checkid);
        teacherService.deleChecks(checkid);
        return "redirect:/teacher/getCheck";
    }
    //历史记录
    @RequestMapping("/getCheckHistory")
    public String getCheckHistory(HttpServletRequest request, Model model,@RequestParam(defaultValue = "1",value = "pageNum") Integer pageNum) {
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        PageHelper.startPage(pageNum,10);
        List<Checks> admin = teacherService.selectCheckes(account);
        PageInfo<Checks> pageInfo = new PageInfo<>(admin);
        model.addAttribute("pageInfo",pageInfo);
        if(admin.isEmpty()){
            return "null";
        }else{
            model.addAttribute("checks", admin);
            return "tea_checkHistory";
        }
    }
    //修改拒绝
    @RequestMapping("/updateChecks/{checkid}")
    public String updateChecks(HttpServletRequest request, @PathVariable("checkid") Integer checkid) {
        request.getSession().setAttribute("checkid",checkid);
        teacherService.updateChecks(checkid);
        return "redirect:/teacher/getCheck";
    }

    //根据课程查询班级学生
    @RequestMapping("/getStudent/{cname}")
    public String getStudent(HttpServletRequest request,Model model,@PathVariable("cname") String cname){
        request.getSession().setAttribute("cname",cname);
        Classes classes = teacherService.selectClasses(cname);
        if (classes == null){
            return "null";
        }else {
            int classid = classes.getClassid();
            List<Student> admin = teacherService.selectStudent(classid);
            PageInfo<Student> pageInfo = new PageInfo<>(admin);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("classes",classes);
            return "tea_findStudent";
        }
    }
    //开始签到
    @RequestMapping(value = "/begintemp/{classid}")
    public String Begintemp(HttpServletRequest request, Model model,@PathVariable("classid") Integer classid) {

        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Teacher teacher = teacherService.selectTeacher(account);
        model.addAttribute("teacher", teacher);
        teacherService.Begintemp(classid);
        return "part";
    }
    //跳到结束签到按钮
    @RequestMapping("/getClass/{cname}")
    public String getChecks(HttpServletRequest request,Model model,@PathVariable("cname") String cname){
        request.getSession().setAttribute("cname",cname);
        Classes classes = teacherService.selectClasses(cname);
        if (classes == null){
            return "null";
        }else {
            int classid = classes.getClassid();
            List<Student> admin = teacherService.selectStudent(classid);
            PageInfo<Student> pageInfo = new PageInfo<>(admin);
            model.addAttribute("pageInfo",pageInfo);
            model.addAttribute("classes",classes);
            return "tea_endStudent";
        }
    }
    //结束签到并到开始签到按钮
    @RequestMapping(value = "/Endtemp/{classid}")
    public String Endtemp(HttpServletRequest request, Model model,@PathVariable("classid") Integer classid) {
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Teacher teacher = teacherService.selectTeacher(account);
        model.addAttribute("teacher", teacher);
        teacherService.Endtemp(classid);
        return "parts";
    }
}