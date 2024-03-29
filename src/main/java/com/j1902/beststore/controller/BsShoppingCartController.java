package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.ItemFull;
import com.j1902.beststore.modle.ShoppingCartResult;
import com.j1902.beststore.pojo.*;
import com.j1902.beststore.service.AdminBsOrderFormService;
import com.j1902.beststore.service.BsShoppingCartItemService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class BsShoppingCartController {
    @Autowired
    private BsShoppingCartItemService bsItemService;

    @Autowired
    private AdminBsOrderFormService orderFormService;

    //    到购物车
    @RequestMapping("/toCheckout")
    public String toCheckout(HttpServletRequest request, Integer pageNum, Map<String, Object> map) {
        try {
            BsUser user_info = (BsUser) request.getSession().getAttribute("USER_INFO");
            if (user_info == null) {
                return "redirect:/toLogin";
            }
            Integer id = user_info.getId();
            if (id == null) {
                return "redirect:/toLogin";
            }
            if (pageNum == null) {
                pageNum = 1;
            }

            PageInfo<BsShoppingCart> pageInfo = bsItemService.pageBsShoppingCart(id, pageNum, 3);
            int[] navigatepageNums = pageInfo.getNavigatepageNums();
            for (int navigatepageNum : navigatepageNums) {
            }
            map.put("PAGEINFO", pageInfo);
            if (pageInfo == null) {
                return "checkout";
            }
            List<ItemFull> itemFulls = new ArrayList<>();
            for (BsShoppingCart shoppingCart : pageInfo.getList()) {
                Integer shoppingCartId = shoppingCart.getId();
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
            return "checkout";
        } catch (Exception e) {
            return "error/index";
        }
    }

    //    修改购物车商品数量
    @RequestMapping("/setItemNumber")
    @ResponseBody
    public ShoppingCartResult setItemNumber(Integer shoppingId, Integer number, Integer result) {
        if (result == 1) {
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

    //    付款
    @RequestMapping("/payment")
    @ResponseBody
    public ShoppingCartResult payment(int[] shoppingCartIdList, HttpSession session) {
        boolean b = false;
        boolean b1 = false;
        for (Integer integer : shoppingCartIdList) {
            BsShoppingCart bsShoppingCartById = bsItemService.getBsShoppingCartById(integer);
            Integer userId = bsShoppingCartById.getUserId();
            Integer itemId = bsShoppingCartById.getItemId();
            Integer number = bsShoppingCartById.getNumber();
            BsItem item = bsItemService.getItem(itemId);
            BsUser user = (BsUser) session.getAttribute("USER_INFO");
            for (int i = 1; i <= number; i++) {
                BsItem item1 = bsItemService.getItem(itemId);
                item1.setId(itemId);
                item1.setInventory(item1.getInventory() - 1);
                item1.setSalesVolume(item1.getSalesVolume() + 1);
                boolean b2 = bsItemService.setNumber(item1);
                BsOrderForm orderForm = new BsOrderForm();
                orderForm.setUserId(user.getId());
                orderForm.setItemId(itemId);
                orderForm.setCreateTime(new Date());
                orderForm.setOrderId(UUID.randomUUID().toString());
                orderForm.setState("1");
                b = orderFormService.addOrderForms(orderForm);
            }
            b1 = bsItemService.removeShoppingCart(integer);

        }
        if (b && b1) {
            ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
            shoppingCartResult.setReslut(true);
            return shoppingCartResult;
        }
        ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
        shoppingCartResult.setReslut(false);
        return shoppingCartResult;
    }
    //    单件商品的付款
    @RequestMapping("/paymentOne")
    @ResponseBody
    public ShoppingCartResult paymentOne(Integer id) {
        boolean b = false;
        boolean b1 = false;
        BsShoppingCart bsShoppingCartById = bsItemService.getBsShoppingCartById(id);
        Integer userId = bsShoppingCartById.getUserId();
        Integer itemId = bsShoppingCartById.getItemId();
        Integer number = bsShoppingCartById.getNumber();

        for (int i = 1; i <= number; i++) {
            BsItem item1 = bsItemService.getItem(itemId);
            item1.setId(itemId);
            item1.setInventory(item1.getInventory() - 1);
            item1.setSalesVolume(item1.getSalesVolume() + 1);
            boolean b2 = bsItemService.setNumber(item1);
            BsOrderForm orderForm = new BsOrderForm();
            orderForm.setUserId(userId);
            orderForm.setItemId(itemId);
            orderForm.setCreateTime(new Date());
            orderForm.setOrderId(UUID.randomUUID().toString());
            orderForm.setState("1");
            b = orderFormService.addOrderForms(orderForm);
        }
        b1 = bsItemService.removeShoppingCart(id);
        if (b && b1) {
            ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
            shoppingCartResult.setReslut(true);
            return shoppingCartResult;
        }
        ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
        shoppingCartResult.setReslut(false);
        return shoppingCartResult;
    }
}
