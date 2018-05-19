package com.learning.testng;

import org.testng.annotations.*;

public class Testcase {
    @Test
    public void testCase1(){
        System.out.println("testCase1执行了");
    }
    @Test
    public void testCase2(){
        System.out.println("testCase2执行了");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforeMethod执行了");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("afterMethod执行了");
    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("beforeClass执行了");
    }

    @AfterClass
    public void afterClass(){
        System.out.println("afterClass执行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite执行了");
    }
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("beforeSuite执行了");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("beforeTest执行了");
    }
    @AfterTest
    public void afterTest(){
        System.out.println("afterTest执行了");
    }
    @Test(enabled = false)
    public void ignoreTest(){
        System.out.println("忽略测试");
    }
}
