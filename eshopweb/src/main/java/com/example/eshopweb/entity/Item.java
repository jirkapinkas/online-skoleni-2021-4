package com.example.eshopweb.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Getter
@Setter
@Entity
public class Item {

    @Id
    @Column(name = "item_id")
    private int id;

    private String name;

    private String description;

    private double price;

}
