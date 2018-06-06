package com.course.model;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer price;
    @Override
    public String toString(){
        return("{id:"+id+","+
        "name"+name+","+
        "storeId:"+storeId+","+
        "price"+price+"}");
    }
}
