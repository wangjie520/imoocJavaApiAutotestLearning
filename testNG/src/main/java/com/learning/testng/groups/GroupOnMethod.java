package com.learning.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

import java.security.acl.Group;

public class GroupOnMethod {
    @Test(groups = "DOD")
    public  void DODmethod1(){
        System.out.println("DOD method1执行");
    }
    @Test(groups="DOD")
    public  void DODmethod2(){
        System.out.println("DOD method2执行");
    }

    @Test(groups="DMT")
    public  void DMTmethod1(){
        System.out.println("DMT method1执行");
    }
    @Test(groups="DMT")
    public  void DMTmethod2(){
        System.out.println("DMT method2执行");
    }
    @BeforeGroups("DMT")
    public void beforeDMTgroups(){
        System.out.println("beforeDMTgroups执行了");
    }
    @AfterGroups("DMT")
    public void afterDMTgroups(){
        System.out.println("afterDMTgroups执行了");
    }


}
