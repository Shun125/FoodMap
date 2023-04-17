package com.example.demo.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

@Data
//@Entity
//@Table(name="shop2")
//@IdClass(value=ShopKey.class)
public class Shop implements Serializable {
	
	private Long id;

	private String name;

	private String city;

	private String menu;

	private int shopcom;

	private int price;

	private int foodcom;
	
	 /**
     * 更新日時
     */
    private Date updateDate;
    /**
     * 登録日時
     */
    private Date createDate;
    /**
     * 削除日時
     */
    private Date deleteDate;
}
