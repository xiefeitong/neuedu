package com.neuedu.controller;

import com.neuedu.consts.Const;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
@RequestMapping("/user/")
public class UserController {

    @Autowired
    IUserService userService;



    @RequestMapping(value = "login",method = RequestMethod.GET)
    public  String login(){
        return "login";
    }

    @RequestMapping(value = "login",method = RequestMethod.POST)
    public  String login(UserInfo userInfo, HttpSession session, HttpServletResponse response){

       UserInfo loginUserInfo= userService.login(userInfo);

       // System.out.println(loginUserInfo);

        if(loginUserInfo!=null){
            //七天免登陆
            Cookie username_cookie=new Cookie("username",loginUserInfo.getUsername());
            username_cookie.setMaxAge(7*24*3600);
            response.addCookie(username_cookie);
            Cookie password_cookie=new Cookie("password",loginUserInfo.getPassword());
            username_cookie.setMaxAge(7*24*3600);
            response.addCookie(password_cookie);



            session.setAttribute(Const.CURRENT_USER,loginUserInfo);

            return "home/home";


        }

        return "/login";

    }


    @RequestMapping("home")
    public  String  home(){

        return "home";
    }





}
