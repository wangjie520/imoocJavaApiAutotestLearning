package com.course.controller;
import com.course.model.Menu;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@Log4j
@Api(value="/mybatis",description ="增删改查" )
@RequestMapping(value="/mybatis")
@RestController
public class Demo {
    //声明一个执行sql的对象
    @Autowired//启动即加载
    private SqlSessionTemplate template;
    @RequestMapping(value="/getMenuCount",method = RequestMethod.GET)
    @ApiOperation(value="获取菜单总数",httpMethod = "GET")
    public Integer getMenuCount(){
        return template.selectOne("getMenuCount");
    }
    @RequestMapping(value="/addMenu",method=RequestMethod.POST)
    @ApiOperation(value="新增菜",httpMethod = "POST")
    public Integer addMenu(@RequestBody Menu menu){
        return template.insert("addMenu",menu);

    }
    @RequestMapping(value="/updateMenu",method=RequestMethod.POST)
    @ApiOperation(value="更新菜",httpMethod = "POST")
    public int updateMenu(@RequestBody Menu menu){
        return  template.update("updateMenu",menu);
    }

    @RequestMapping(value="/deleteItem",method=RequestMethod.GET)
    @ApiOperation(value="删除菜",httpMethod = "GET")
    public int delMenu(@RequestParam Integer id){
        return template.delete("deleteMenu",id);
    }

}
