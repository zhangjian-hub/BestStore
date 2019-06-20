package com.j1902.beststore.controller;

import com.j1902.beststore.modle.ItemFull;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsItemService;
import com.j1902.beststore.service.BsUserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsUserController {

    @Autowired
    private BsUserService bsUserService;

    @Autowired
    private BsItemService bsItemService;

    @RequestMapping("/toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("/toRegister")
    public String toRegister() {
        return "register";
    }

    @RequestMapping("/register")
    public String register(BsUser bsUser, Map<String, Object> map) {
        System.out.println("bsUser = [" + bsUser + "]");
        if (bsUserService.isExistBsUser(bsUser)) {
            return "register";
        }
        map.put("REGISTER_STATE", "fail");
        bsUserService.addBsUser(bsUser);
        return "login";
    }

    @RequestMapping("/toHome")
    public String toHome() {
        return "home";
    }

    @RequestMapping("/toCheckout")
    public String toCheckout(Integer id, Map<String, Object> map) {
        if (id == null) {
            return "redirect:/toLogin";
        }
        List<BsShoppingCart> bsShoppingCart = bsItemService.getBsShoppingCart(id);
        if(bsShoppingCart == null){
            return "checkout";
        }
        List<ItemFull> itemFulls = new ArrayList<>();
        for (BsShoppingCart shoppingCart : bsShoppingCart) {
            System.out.println("shoppingCart = " + shoppingCart);
            Integer itemId = shoppingCart.getItemId();
            System.out.println("itemId = " + itemId);
            Integer number = shoppingCart.getNumber();
            System.out.println("number = " + number);
            BsItem item = bsItemService.getItem(1);
            System.out.println("item = " + item);
            ItemFull itemFull = new ItemFull();
            itemFull.setId(item.getId());
            itemFull.setName(item.getName());
            itemFull.setSuitablePeople(item.getSuitablePeople());
            itemFull.setType(item.getType());
            itemFull.setSize(item.getSize());
            itemFull.setColor(item.getColor());
            itemFull.setPrice(item.getPrice());
            itemFull.setInventory(item.getInventory());
            itemFull.setImage(item.getImage());
            itemFull.setSalesVolume(item.getSalesVolume());
            itemFull.setDescribe(item.getDescribe());
            itemFull.setSupplier(item.getSupplier());
            itemFull.setNumber(number);
            itemFulls.add(itemFull);
        }
        map.put("ITEM_LIST_SHOPPING", itemFulls);
        return "checkout";
    }

}
