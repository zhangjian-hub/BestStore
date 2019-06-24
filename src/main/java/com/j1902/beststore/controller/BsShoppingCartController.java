package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.ItemFull;
import com.j1902.beststore.modle.ShoppingCartResult;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.service.BsItemService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsShoppingCartController {
    @Autowired
    private BsItemService bsItemService;

    @RequestMapping("/toCheckout")
    public String toCheckout(Integer id, Integer pageNum, Map<String, Object> map) {
        if (id == null) {
            return "redirect:/toLogin";
        }
        if (pageNum == null) {
            pageNum = 1;
        }
//        List<BsShoppingCart> bsShoppingCart = bsItemService.getBsShoppingCart(id);
//        System.out.println("bsShoppingCart = " + bsShoppingCart);
        PageInfo<com.j1902.beststore.pojo.BsShoppingCart> pageInfo = bsItemService.pageBsShoppingCart(id, pageNum, 3);
        System.out.println(pageInfo.getPageSize());
        int[] navigatepageNums = pageInfo.getNavigatepageNums();
        for (int navigatepageNum : navigatepageNums) {
            System.out.println("navigatepageNum = " + navigatepageNum);
        }
        map.put("PAGEINFO", pageInfo);
        if (pageInfo == null) {
            return "checkout";
        }
        List<ItemFull> itemFulls = new ArrayList<>();
        for (BsShoppingCart shoppingCart : pageInfo.getList()) {
            Integer shoppingCartId = shoppingCart.getId();
            System.out.println("shoppingCartId = " + shoppingCartId);
            Integer itemId = shoppingCart.getItemId();
            Integer number = shoppingCart.getNumber();
            BsItem item = bsItemService.getItem(itemId);
            ItemFull itemFull = new ItemFull();
            itemFull.setShoppingCartId(shoppingCartId);
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
            itemFull.setDescription(item.getDescription());
            itemFull.setSupplier(item.getSupplier());
            itemFull.setNumber(number);
            itemFulls.add(itemFull);
        }
        map.put("ITEM_LIST_SHOPPING", itemFulls);
        System.out.println("itemFulls = " + itemFulls.size());
        return "checkout";
    }

    //    修改购物车商品数量
    @RequestMapping("/setItemNumber")
    @ResponseBody
    public ShoppingCartResult setItemNumber(Integer shoppingId, Integer number, Integer result) {
        System.out.println("shoppingId = [" + shoppingId + "], number = [" + number + "], result = [" + result + "]");
        if (result == 1) {
            System.out.println("加一");
//            为加一
            BsShoppingCart bsShoppingCart = new BsShoppingCart();
            bsShoppingCart.setId(shoppingId);
            bsShoppingCart.setNumber(number + 1);
            boolean b = bsItemService.updateItemNumber(bsShoppingCart);
            ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
            shoppingCartResult.setReslut(b);
            return shoppingCartResult;
        }
        if (result == 2) {
//            为减一
            if (number == 1) {
                ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
                shoppingCartResult.setReslut(false);
                return shoppingCartResult;
            }
            BsShoppingCart bsShoppingCart = new BsShoppingCart();
            bsShoppingCart.setId(shoppingId);
            bsShoppingCart.setNumber(number - 1);
            boolean b = bsItemService.updateItemNumber(bsShoppingCart);
            ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
            shoppingCartResult.setReslut(b);
            return shoppingCartResult;
        }
        return null;
    }

    //    删除购物车
    @RequestMapping("/removeShoppingCart")
    @ResponseBody
    public ShoppingCartResult removeShoppingCart(Integer shoppingCartId, Integer id, Integer pageNum) {
        boolean b = bsItemService.removeShoppingCart(shoppingCartId);
        ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
        shoppingCartResult.setReslut(b);
        return shoppingCartResult;
    }
}
