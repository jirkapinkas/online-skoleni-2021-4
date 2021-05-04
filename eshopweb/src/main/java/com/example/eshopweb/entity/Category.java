package com.example.eshopweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Getter
@Setter
@Entity
public class Category {

    @Id
    private int categoryId;

    private String name;

    @OneToMany(mappedBy = "category")
    private List<Item> items;

}
