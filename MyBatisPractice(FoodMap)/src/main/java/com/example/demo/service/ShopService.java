package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ShopInfoMapper;
import com.example.demo.dto.ShopReq;
import com.example.demo.dto.ShopSearchRequest;
import com.example.demo.dto.ShopUpdateRequest;
import com.example.demo.entity.Shop;

/**
 * お店情報 Service
 */
@Service
public class ShopService {

    /**
     * お店情報 Mapper
     */
    @Autowired
    private ShopInfoMapper shopInfoMapper;

    /**
     * お店情報全件検索
     * @return 検索結果
     */
    public List<Shop>findAll() {
        return shopInfoMapper.findAll();
    }

    /**
     * お店情報主キー検索
     * @return 検索結果
     */
    public Shop findById(Long id) {
        return shopInfoMapper.findById(id);
    }

    /**
     * お店情報検索
     * @param shopSearchRequest リクエストデータ
     * @return 検索結果
     */
    public List<Shop> search(ShopSearchRequest shopSearchRequest) {
        return shopInfoMapper.search(shopSearchRequest);
    }

    /**
     * お店情報登録
     * @param shopAddRequest リクエストデータ
     */
    public void save(ShopReq shopReq) {
        shopInfoMapper.save(shopReq);
    }

    /**
     * お店情報更新
     * @param shopEditRequest リクエストデータ
     */
    public void update(ShopUpdateRequest shopUpdateRequest) {
        shopInfoMapper.update(shopUpdateRequest);
    }

    /**
     * お店情報論理削除
     * @param id
     */
    public void delete(Long id) {
        shopInfoMapper.delete(id);
    }
}