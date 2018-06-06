package com.course.server;

import com.course.bean.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@RestController
@RequestMapping(value="/post")
@Api(value="/",description="这是我全部的post请求")
public class MyPostMethod {
    @RequestMapping(value="/login",method = RequestMethod.POST)
    @ApiOperation(value="post登录接口,返回cookie",httpMethod = "POST")
    public String login(HttpServletResponse response, @RequestParam String userName,@RequestParam String password){
        Cookie cookie=new Cookie("login","true");
        if (userName.equals("wangjie")&&password.equals("123456")){
            response.addCookie(cookie);
            return "login success";
        }
        return "login fail";
    }
   @RequestMapping(value="withcookies",method = RequestMethod.POST)
    @ApiOperation(value="带cookie信息的post请求")
    public UserInfo postWithCookie(HttpServletRequest request, @RequestBody UserInfo user){
        Cookie[] cookies=request.getCookies();
        for(Cookie c:cookies){
            if(c.getName().equals("login")&&c.getValue().equals("true")&& user.getUserName().equals("wangjie")&&user.getPassWord().equals("123456")){
                user.setMobile("15261180520");
                user.setAddress("大可行创业园");
                user.setUserName("王杰");
                return user;
            }
        }
       return user;
    }
}
