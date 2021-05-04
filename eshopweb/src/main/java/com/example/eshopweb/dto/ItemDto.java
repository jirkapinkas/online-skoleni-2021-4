package com.example.eshopweb.dto;

import lombok.Data;

@Data
public class ItemDto {

    private int id;

    private String name;

    private String description;

    private double price;

    private CategoryDto category;

}
