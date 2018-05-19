package com.learning.testng.mutithread;

import org.testng.annotations.Test;

public class AnonationMutiThread {
    @Test(invocationCount = 100,threadPoolSize = 10)
    public void printlnHello(){
        System.out.println("HELLO");
        System.out.println("Threadid:"+Thread.currentThread().getId());
    }
}
