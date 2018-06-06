package com.course.cases;

import com.course.config.TestConfig;
import com.course.model.Menu;
import com.course.model.TestApiName;
import com.course.model.addMenuTest;
import com.course.util.ConfigFile;
import com.course.util.DatabaseUtil;
import lombok.extern.log4j.Log4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.apache.ibatis.session.SqlSession;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;


import static com.course.config.TestConfig.addMenuUrl;
import static com.course.config.TestConfig.defaultHttpClient;
@Log4j
public class AddMenuTest {
    @BeforeTest(groups="addMenu",description = "新增菜单测试")
    public void beforeTest(){
        addMenuUrl=ConfigFile.getUrl(TestApiName.ADDMENU);
        TestConfig.queryMenuUrl=ConfigFile.getUrl(TestApiName.QUERYMENU);
        TestConfig.defaultHttpClient=new DefaultHttpClient();
    }
    @Test(groups = "addMenu")
    public void addMenuTest() throws IOException, InterruptedException {
        SqlSession session=DatabaseUtil.getSqlSession();
        //查询测试数据
        addMenuTest addMenuTestData=session.selectOne("addMenu", 777);
        //把接口测试数据发起http请求，并返回响应
        String result=getResult(addMenuTestData);
        //与预期响应做对比
       Assert.assertEquals(result,addMenuTestData.getExpected());

        //验证数据库是否插入数据成功
        SqlSession session2=DatabaseUtil.getSqlSession();
        Menu insertdata=session2.selectOne("addMenuTest",addMenuTestData);

        // Assert.assertNotNull(insertdata);
        System.out.println(insertdata.toString());
    }

    private String getResult(addMenuTest addMenuTestData) throws IOException {

        TestConfig.defaultHttpClient =new DefaultHttpClient();
        JSONObject param=new JSONObject();
        param.put("id",addMenuTestData.getId());
        param.put("name",addMenuTestData.getName());
        param.put("storeId",addMenuTestData.getStoreId());
        param.put("price",addMenuTestData.getPrice());
        HttpPost post=new HttpPost(addMenuUrl);
        post.setHeader("content-type","application/json");
        //设置传参
        StringEntity entity=new StringEntity(param.toString());
        post.setEntity(entity);

        HttpResponse response=defaultHttpClient.execute(post);

        String result=EntityUtils.toString(response.getEntity(),"utf-8");

        return  result;


    }

}
