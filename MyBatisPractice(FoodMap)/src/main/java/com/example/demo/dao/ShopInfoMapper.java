package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.dto.ShopReq;
import com.example.demo.dto.ShopSearchRequest;
import com.example.demo.dto.ShopUpdateRequest;
import com.example.demo.entity.Shop;

/**
 * お店の情報 Mapper
 */
@Mapper
public interface ShopInfoMapper {

    /**
     * お店の情報全件検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<Shop>findAll();

    /**
     * お店の情報主キー検索
     * @param id 主キー
     * @return 検索結果
     */
    Shop findById(Long id);

    /**
     * お店の情報検索
     * @param user 検索用リクエストデータ
     * @return 検索結果
     */
    List<Shop> search(ShopSearchRequest user);

    /**
     * お店の情報登録
     * @param userRequest 登録用リクエストデータ
     */
    void save(ShopReq shopReq);

    /**
     * お店の情報更新
     * @param userUpdateRequest 更新用リクエストデータ
     */
    void update(ShopUpdateRequest shopUpdateRequest);

    /**
     * お店の情報の論理削除
     * @param id ID
     */
    void delete(Long id);
}