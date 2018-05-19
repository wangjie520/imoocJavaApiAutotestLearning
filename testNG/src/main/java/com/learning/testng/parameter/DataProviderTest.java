package com.learning.testng.parameter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "testMethodData")
    public void addint(int a, int b){
      int   result=a+b;
        System.out.println(a+"+"+b+"="+result);
    }

    @Test(dataProvider = "testMethodData")
    public void diffloat(int c, int d,int e){
        int result=c-d-e;
        System.out.println(c+"-"+d+"-"+e+"="+result);
    }

    @DataProvider(name="testMethodData")
    public Object[][] providerData(Method method){
        Object [][] result=null;
        if (method.getName().equals("addint")){
            result=new Object[][]{{1,3},{2,4}};
        }
        if (method.getName().equals("diffloat")){
            result=new Object[][]{{4,3,1},{294,12,10}};
        }return result;
    }

    @Test(dataProvider = "providerForlogin")
    public  void login(String username){
        System.out.println(username+"登录成功");
    }
    @DataProvider(name="providerForlogin")
    public Object[] providerDataForOneMethod(){
        Object[] result=null;
        result=new Object[]{"angela","jay"};
        return result;
    }
}
