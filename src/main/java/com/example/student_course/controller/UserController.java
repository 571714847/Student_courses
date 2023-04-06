package com.example.student_course.controller;

import com.example.student_course.domain.User;
import com.example.student_course.service.UserService;
import com.example.student_course.unil.MD5Utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    //实现登录
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public String show(){
        return "login";
    }


    @RequestMapping("/user")
    public String login(@RequestParam("account") Integer account,@RequestParam("password1") String password1, HttpServletRequest request, Map<String, Object> map){
        try {
            String password2 = MD5Utils.code(password1);
            User login = userService.loginService(account, password2);
            HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
            if (login != null) {
                if (login.getType1().equals("管理员")) {
                    request.getSession().setAttribute("account",String.valueOf(login.getAccount()));
                    return "redirect:/admin/getIndex";
                } else if (login.getType1().equals("学生")) {
                    request.getSession().setAttribute("account",String.valueOf(login.getAccount()));
                    return "redirect:/student/getIndex";
                } else if (login.getType1().equals("教师")) {
                    request.getSession().setAttribute("account",String.valueOf(login.getAccount()));
                    return "redirect:/teacher/getIndex";
                }else {
                    objectObjectHashMap.put("id","用户名或密码错误，请重试");
                    map.put("msg",objectObjectHashMap);
                    return "logins";
                }
            } else {
                objectObjectHashMap.put("id","用户名或密码错误，请重试");
                map.put("msg",objectObjectHashMap);
                return "logins";
            }
        }catch (Exception e){
            return "error";
        }
    }

    @RequestMapping(value = "/loginOut", method = {RequestMethod.GET})
    public String loginOut(HttpServletRequest request) {
        request.getSession().removeAttribute("account");
        return "redirect:login";
    }
}