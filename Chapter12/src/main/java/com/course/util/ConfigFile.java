package com.course.util;

import com.course.model.TestApiName;

import java.util.ResourceBundle;

public class ConfigFile {
    private static ResourceBundle bundle=ResourceBundle.getBundle("application");
    public static String getUrl(TestApiName name){
        String address=bundle.getString("test.url");
        String uri="";
        String testUrl;
        if(name==TestApiName.ADDMENU){
            uri=bundle.getString("addMenu.uri");
        }
        if(name==TestApiName.QUERYMENU){
            uri=bundle.getString("queryMenuById.uri");
        }
        testUrl=address+uri;
        return  testUrl;

    }

}
