package com.learning.testng.suite;

import org.testng.annotations.*;

public class SuiteConfig {
    @BeforeSuite
    private void beforeSuite(){
        System.out.println("beforeSuite运行了");
    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("afterSuite运行了");
    }
    @BeforeTest
    private void beforeclass(){
        System.out.println("beforeTest运行了");
    }
    @AfterTest
    public void afterclass(){
        System.out.println("afterTest运行了");
    }

}
