package com.learning.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
//使用xml传递参数，运行parameter.xml

public class ParameterTest {
    @Test
    @Parameters({"name","age"})
    public void testParameter(String name,int age){
        System.out.println("名字是"+name+"\n年龄是"+age);
    }
}
