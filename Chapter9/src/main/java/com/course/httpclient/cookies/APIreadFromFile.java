package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class APIreadFromFile {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void inittest(){
        bundle=ResourceBundle.getBundle("application",Locale.CHINA);//application.properties必须放在resource下
        url=bundle.getString("test.url");
    }
    @Test
    public void testLoin() throws IOException {
        String testUrl;
        String uri=bundle.getString("login");
        testUrl=url+uri;
        HttpGet get=new HttpGet(testUrl);
        HttpClient client=new DefaultHttpClient();
        HttpResponse response=client.execute(get);
        String result=EntityUtils.toString(response.getEntity(),"utf-8");

        System.out.println(result);
        store=((DefaultHttpClient) client).getCookieStore();
        List<Cookie> cookieList=store.getCookies();
        for(Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println(name+":"+value);
        }
    }

    @Test(dependsOnMethods = {"testLoin"})
    public void testGetWithCookie() throws IOException {
        String testUrl;
        String uri=bundle.getString("get.withCookies");
        testUrl=url+uri;
        HttpGet get=new HttpGet(testUrl);
        HttpClient client=new DefaultHttpClient();

        ((DefaultHttpClient) client).setCookieStore(store);

        HttpResponse response=client.execute(get);

        int statusCode=response.getStatusLine().getStatusCode();
        if (statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
        }


    }

    @Test(dependsOnMethods = {"testLoin"})
    public void testPostWithCookie() throws IOException {
        String uri=bundle.getString("post.withCookies");
        String testUrl=url+uri;
        //声明用来执行请求的客户端
        HttpClient client=new DefaultHttpClient();
        //声明一个post请求
        HttpPost post=new HttpPost(testUrl);
        //声明传参
        JSONObject param=new JSONObject();
        param.put("name","huanhansan");
        param.put("sex","2");
        //声明请求头
        post.setHeader("content-type","application/json");
        //设置传参
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);

        //执行请求
        ((DefaultHttpClient) client).setCookieStore(store);
        HttpResponse response=client.execute(post);

        int statusCode=response.getStatusLine().getStatusCode();
        if (statusCode==200){
            String result=EntityUtils.toString(response.getEntity(),"utf-8");
            System.out.println(result);
            //判断结果
            JSONObject resultjson=new JSONObject(result);
            String home=resultjson.getString("home");
            Assert.assertEquals("casaresidency",home);
        }

    }
}
