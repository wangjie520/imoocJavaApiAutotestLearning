package com.learning.testng;

import org.testng.annotations.Test;

public class TimeOutTest {
    @Test(timeOut = 3000)
    public void testTimeOut() throws InterruptedException {
        Thread.sleep(4000);
    }
    @Test(timeOut = 3000)
    public void testTimeOut2() {
      //  for(int i=1;i>0;i++){
      //  System.out.println(i);
      //  }
        int a=0;
    while(true){
        a=a+1;
    }
    }
}
