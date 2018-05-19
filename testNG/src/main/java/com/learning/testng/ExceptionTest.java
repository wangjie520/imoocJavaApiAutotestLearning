package com.learning.testng;

import org.testng.annotations.Test;

import java.util.concurrent.TimeoutException;

public class ExceptionTest {
    @Test(expectedExceptions=RuntimeException.class)
    public void timeOut(){
        System.out.println("成功的超时异常测试");
        throw new RuntimeException();
    }

    @Test(expectedExceptions=RuntimeException.class)
    public void failexception(){
        System.out.println("失败的超时异常测试");
    }
}
