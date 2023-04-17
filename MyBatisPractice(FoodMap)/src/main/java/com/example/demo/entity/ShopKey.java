package com.example.demo.entity;

import java.io.Serializable;

import lombok.Data;

@Data
public class ShopKey implements Serializable {
	public ShopKey() {
	}
	public ShopKey(String name, String menu) {
		super();
		this.name = name;
		this.menu = menu;
	}
	private String name;
	private	String menu;	
}
