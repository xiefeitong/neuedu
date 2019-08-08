package com.neuedu.interceptors;

import com.mchange.v2.lang.StringUtils;
import com.neuedu.exception.MyException;
import com.neuedu.pojo.UserInfo;
import com.neuedu.service.IUserService;
import com.neuedu.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class AuthorityInterceptor implements HandlerInterceptor {
    @Autowired
    IUserService userService;

@Override
    public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object Handler) throws MyException,IOException{


        UserInfo userinfo=new UserInfo() ;
        request.getCookies();
        Cookie[] cookies = request.getCookies();
        String username = null;
        String password = null;
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                /**
                 * 查找username和pasword的cookie,并取得相应的值
                 * */
                String username_cookie = cookies[i].getName();
                String password_cookie = cookies[i].getName();
                System.out.println(cookies[i].getName());
                if (username_cookie.equals("username")) {
                    username = cookies[i].getValue();
                }
                if (password_cookie.equals("password")) {
                    password = cookies[i].getValue();
                }
            }
        }
        if (username != null && password != null) {
            /**
             * 拿到cookie之后去进行登录检测，查看是否为合法用户
             * */

            userinfo.setUsername(username);
            userinfo.setPassword(password);


            UserInfo loginUserInfo = userService.login(userinfo);

          //  System.out.println(loginUserInfo.getUsername());
            if (loginUserInfo != null) {
                return true;
            }


        }
    try {
        response.sendRedirect("/user/login");
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false;
    }
}







   /* private List<String> exceptUrls;

    public List<String> getExceptUrls() {
        return exceptUrls;
    }

    public void setExceptUrls(List<String> exceptUrls) {
        this.exceptUrls = exceptUrls;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {

        String requestUri = request.getRequestURI();
        if(requestUri.startsWith(request.getContextPath())){
            requestUri = requestUri.substring(request.getContextPath().length(), requestUri.length());
        }
        //系统根目录
      *//*  if (StringUtils.equals("/",requestUri)) {
            return true;
        }*//*
        //放行exceptUrls中配置的url
        for (String url:exceptUrls) {
            if(url.endsWith("/**")){
                if (requestUri.startsWith(url.substring(0, url.length() - 3))) {
                    return true;
                }
            } else if (requestUri.startsWith(url)) {
                return true;
            }
        }

        //判断用户是否已经登陆（登陆的用户信息在session中）
        HttpSession session = request.getSession();
        //从session中取出用户身份信息
        UserInfo user = (UserInfo) session.getAttribute("user");

        if(user != null){
            //已经登陆，放行
            return true;
        }else{
            //去登陆页面登陆
            request.getRequestDispatcher("/jsp/loginmoban/log.jsp").forward(request, response);
            return false;
        }
    }*/

  /*  @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {


    }

    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {


    }*/


