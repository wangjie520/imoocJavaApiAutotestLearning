package com.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PreDestroy;

//入口应用程序，注意application的层级，这种写法不用配置扫描包
@SpringBootApplication
@EnableScheduling
public class Application {
    private static ConfigurableApplicationContext context;
    public static void main(String[] args){
        Application.context=SpringApplication.run(Application.class,args);
    }
    @PreDestroy
    public void close(){
        Application.context.close();
    }
}
