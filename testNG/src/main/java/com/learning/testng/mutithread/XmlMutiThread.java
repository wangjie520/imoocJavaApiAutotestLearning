package com.learning.testng.mutithread;

import org.testng.annotations.Test;

public class XmlMutiThread {
    @Test
    public void test1(){
        System.out.println("Thread:"+Thread.currentThread().getId());
    }
    @Test
    public void test2(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

    @Test
    public void test3(){
        System.out.printf("Thread Id : %s%n",Thread.currentThread().getId());
    }

}
