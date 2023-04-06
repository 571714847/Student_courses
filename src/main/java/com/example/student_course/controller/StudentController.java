package com.example.student_course.controller;

import com.example.student_course.domain.Classes;
import com.example.student_course.domain.Student;
import com.example.student_course.domain.Teacher;
import com.example.student_course.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/student")
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping("/getIndex")
    public String getIndex(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Student student = studentService.selectStudent(account);
        model.addAttribute("student", student);
        return "stu_index";
    }
    //个人信息查询
    @RequestMapping("/getAllStudent")
    public String getStudent(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Student student = studentService.selectStudent(account);
        model.addAttribute("student",student);
        return "stu_find";
    }

    @RequestMapping("/updatesStudent")
    public String updatesTeacher(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Student student = studentService.selectStudent(account);
        model.addAttribute("update", student);
        return "stu_update";
    }

    @PostMapping("/updateStudent/{sid}")
    public String updateStudent(Student student,HttpServletRequest request){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        student.setSid(account);
        studentService.updateStudent(student);
        return "redirect:/student/getAllStudent";
    }

    @RequestMapping("/getAllSClass")
    public String getClass(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Classes classes = studentService.selectClass(account);
        model.addAttribute("classes",classes);
        return "stu_findClass";
    }

    @RequestMapping("/getClassCourse")
    public String getClassCourse(HttpServletRequest request, Model model){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Classes classes = studentService.selectClass(account);
        model.addAttribute("classes",classes);
        return "stu_findCourse";
    }

    //查询单个课表信息
    @RequestMapping("/getCheck/{mcourse1}")
    public String getCheck(HttpServletRequest request,Model model,@PathVariable("mcourse1") String mcourse1){
        Teacher course = studentService.selectCourse(mcourse1);
        model.addAttribute("course",course);
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Student student = studentService.selectStudent(account);
        model.addAttribute("student",student);
        return "stu_course";
    }

    //请假
    @RequestMapping("/addStudent/{classid}")
    public String addStudent(Model model,HttpServletRequest request,Student student,@PathVariable("classid") Integer classid){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        Integer sid = studentService.selectState(account);
        Integer studentid = studentService.selectcheck(account);
        String msg="请勿重复请假";
        if(sid != null){
            model.addAttribute("msg",msg);
            return "msg";
        }else if (studentid != null){
            model.addAttribute("msg",msg);
            return "msg";
        }else {
            student.setSid(account);
            student.setClassid(classid);
            String s = studentService.insertCheck(student);
            if (s.equals("true")){
                return "redirect:/student/getAllSClass";
            }else{
                return "500";
            }
        }
    }

    //销假
    @RequestMapping("/deleteCheck")
    public String deleteCheck(HttpServletRequest request){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        studentService.deleteCheck(account);
        return "redirect:/student/getAllSClass";
    }

    //学生签到
    @RequestMapping("/addtemp/")
    public String addtemp(HttpServletRequest request,Student student){
        String a = (String) request.getSession().getAttribute("account");
        int account = Integer.parseInt(a);
        String classids = a.substring(0,4);
        int classid = Integer.parseInt(classids);
        student.setSid(account);
        student.setClassid(classid);
        String s = studentService.addtemp(student);
        if (s.equals("true")){
            return "redirect:/student/getAllSClass";
        }else{
            return "500";
        }
    }
}
