package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

/**
 * ユーザー情報登録 リクエストデータ
 */
@Data
public class ShopReq implements Serializable {
	  @NotEmpty(message = "名前を入力してください")
	  @Size(max = 100, message = "名前は100桁以内で入力してください")
	  private String name;

	  @NotEmpty(message = "お店の場所を入力してください")
	  @Size(max = 100, message = "名前は100桁以内で入力してください")
	  private String city;
	 
	  @NotEmpty(message = "ご注文の名前を入力してください")
	  @Size(max = 100, message = "名前は100桁以内で入力してください")
	  private String menu;
	  
	  @NotNull(message = "お店の評価を入力してください")
	  @Min(value = 1, message = "評価は1以上でなければなりません")
	  @Max(value = 5, message = "評価は5以下でなければなりません")
	  private Integer shopcom;
	  
	  @NotNull(message = "ご注文の値段を入力してください")
	  @Min(value = 1, message = "価格は1以上でなければなりません")
	  @Max(value = 100000, message = "価格は100000以下でなければなりません")
	  private Integer price;
	  
	  @NotNull(message = "ご注文の評価を入力してください")
	  @Min(value = 1, message = "評価は1以上でなければなりません")
	  @Max(value = 5, message = "評価は5以下でなければなりません")
	  private Integer foodcom;
}