package com.course.model;

import lombok.Data;

@Data
public class Menu {
    private Integer id;
    private String name;
    private Integer storeId;
    private Integer price;
}
