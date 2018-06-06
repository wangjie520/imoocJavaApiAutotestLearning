package com.course.server;



import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@RestController
@Api(value="/",description = "这是我开发的全部get请求")
public class MyGetMethod {
    @ApiOperation(value="登录",httpMethod = "GET")
    @RequestMapping(value="/login",method = RequestMethod.GET)
    public String login(HttpServletResponse response){
        //  HttpServletResponse装响应信息的类
        //  HttpServletRequest装请求信息的类
        Cookie cookie=new Cookie("token","ABC");
        response.addCookie(cookie);
        return "登录成功，获取cookie成功";
    }
    @RequestMapping(value = "/get/withcookies",method = RequestMethod.GET)
    @ApiOperation(value="携带cookie的get请求",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            return "请登录";
        }
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("token")&&cookie.getValue().equals("ABC"));
            return "with cookies get请求成功";
        }
        return "cookie信息缺失";
    }
    //带参数的get请求
    //http://localhost:8888/get/withparam?minprice=100&maxprice=500
    //@RequestMapping(value="/get/withparam",method = RequestMethod.GET)
    @RequestMapping(value="/get/withparam")
    @ApiOperation(value="带参数的get请求",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer minprice,@RequestParam Integer maxprice){
        Map<String,Integer> list=new HashMap<String,Integer>();
        list.put("鞋子",500);
        list.put("衬衣",300);
        list.put("裤子",200);
        return  list;
    }
    //带参数的另一种请求方式
    //http://localhost:8888/get/withparam/100/500/
    @RequestMapping(value="/get/withparam/{minprice}/{maxprice}",method = RequestMethod.GET)
    @ApiOperation(value="带参数restful风格的get请求",httpMethod = "GET")
    public Map<String,Integer> getList2(@PathVariable Integer minprice, @PathVariable Integer maxprice){
        Map<String,Integer> list=new HashMap<String,Integer>();
        list.put("鞋子",500);
        list.put("衬衣",300);
        list.put("裤子",200);
        return  list;
    }
}
