package com.learning.testng;

import org.testng.annotations.Test;

public class DependTest {
    @Test
    public void login(){
        System.out.println("正在登录");
        throw new RuntimeException();
    }
    @Test(dependsOnMethods = "login")
    public void modyname(){
        System.out.println("修改昵称成功");
    }
}
