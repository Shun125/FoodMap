package com.example.demo.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShopSearchRequest implements Serializable {

	private String id;
    private String name;
    private String city;
    private String menu;
    private int shopcom;
    private int foodcom;
}