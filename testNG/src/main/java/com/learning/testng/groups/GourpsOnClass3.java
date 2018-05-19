package com.learning.testng.groups;

import org.testng.annotations.Test;

@Test(groups="teacher")
public class GourpsOnClass3 {
    public void tea(){
        System.out.println("class3中的tea运行了");
    }
}
