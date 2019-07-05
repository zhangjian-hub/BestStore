package com.j1902.beststore.controller;

import com.j1902.beststore.modle.AddCartResult;
import com.j1902.beststore.pojo.BsShoppingCart;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.AddService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AddCartController {
    @Autowired
    private AddService addService;

    @RequestMapping("/toAddCart")
    @ResponseBody
    private AddCartResult addCart(Integer id, HttpServletRequest request) {
        HttpSession session = request.getSession();
        BsUser user_info = (BsUser) session.getAttribute("USER_INFO");
        System.out.println("user_info = " + user_info);
        AddCartResult addCartResult = new AddCartResult();
        if (user_info != null && !"".equals(user_info.getEmail())) {
            BsShoppingCart bsShoppingCart = new BsShoppingCart();
            bsShoppingCart.setItemId(id);
            BsShoppingCart bsShoppingCart1 = addService.selectShopping(bsShoppingCart);
            if (bsShoppingCart1 == null || bsShoppingCart1.getUserId() != user_info.getId()) {
                bsShoppingCart.setNumber(1);
                bsShoppingCart.setUserId(user_info.getId());
                addService.addCart(bsShoppingCart);
                addCartResult.setResult(true);
                return addCartResult;
            } else if (id == bsShoppingCart1.getItemId()) {
                bsShoppingCart1.setNumber(bsShoppingCart1.getNumber() + 1);
                addService.updateShopping(bsShoppingCart1);
                addCartResult.setResult(true);
                return addCartResult;
            }
        }
        addCartResult.setResult(false);
        return addCartResult;
    }
}

