package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.demo.dto.ShopReq;
import com.example.demo.dto.ShopSearchRequest;
import com.example.demo.dto.ShopUpdateRequest;
import com.example.demo.entity.Shop;
import com.example.demo.service.ShopService;


@Controller
public class ShopController2 {
	@Autowired
	private ShopService shopService;
	
	@GetMapping(value = "/shop/list")
	  public String displayList(Model model) {
	    List<Shop>shoplist = shopService.findAll();
	      model.addAttribute("shoplist", shoplist);
	      model.addAttribute("shopSearchRequest", new ShopSearchRequest());
	      return "shop/search";
	  }
	
	@GetMapping(value = "/shop/add")
	  public String displayAdd(Model model) {
		model.addAttribute("ShopReq", new ShopReq());
	    return "shop/add";
	  }
	
	 @GetMapping("/shop/{id}/edit")
	    public String displayEdit(@PathVariable Long id, Model model) {
	        Shop shop = shopService.findById(id);
	        ShopUpdateRequest shopUpdateRequest = new ShopUpdateRequest();
	        shopUpdateRequest.setId(shop.getId());
	        shopUpdateRequest.setName(shop.getName());
	        shopUpdateRequest.setCity(shop.getCity());
	        shopUpdateRequest.setFoodcom(shop.getFoodcom());
	        shopUpdateRequest.setMenu(shop.getMenu());
	        shopUpdateRequest.setPrice(shop.getPrice());
	        shopUpdateRequest.setShopcom(shop.getShopcom());
	        model.addAttribute("shopUpdateRequest", shopUpdateRequest);
	        return "shop/edit";
	    }
	 
    @RequestMapping(value = "/shop/search", method = RequestMethod.POST)
    public String search(@ModelAttribute ShopSearchRequest shopSearchRequest, Model model) {
        List<Shop> shopList = shopService.search(shopSearchRequest);
        model.addAttribute("shoplist", shopList);
        return "shop/search";
    }
    
	@PostMapping("/shop/create")
    public String create(@Validated @ModelAttribute ShopReq shopReq, BindingResult result, Model model) {
        if (result.hasErrors()) {
            // 入力チェックエラーの場合
            List<String> errorList = new ArrayList<String>();
            for (ObjectError error : result.getAllErrors()) {
                errorList.add(error.getDefaultMessage());
            }
            model.addAttribute("validationError", errorList);
            return "shop/add";
        }
        // お店情報の登録
        shopService.save(shopReq);
        return "redirect:/shop/list";
    }
	  
	  @GetMapping("/shop/{id}/delete")
	  public String delete(@PathVariable Long id, Model model) {
	    // お店情報の削除
	    shopService.delete(id);
	    return "redirect:/shop/list";
	  }
	  
	  @RequestMapping(value = "/shop/update", method = RequestMethod.POST)
	    public String update(@Validated @ModelAttribute ShopUpdateRequest shopUpdateRequest, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            List<String> errorList = new ArrayList<String>();
	            for (ObjectError error : result.getAllErrors()) {
	                errorList.add(error.getDefaultMessage());
	            }
	            model.addAttribute("validationError", errorList);
	            return "shop/edit";
	        }
	        // お店情報の更新
	        shopService.update(shopUpdateRequest);
	        return "redirect:/shop/list";
	    }
}

