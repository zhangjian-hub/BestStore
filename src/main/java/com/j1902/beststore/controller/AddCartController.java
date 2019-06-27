package com.j1902.beststore.controller;

import com.j1902.beststore.modle.AddCartResult;
import com.j1902.beststore.pojo.BsShoppingCart;
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
        Object user_info = session.getAttribute("USER_INFO");
        AddCartResult addCartResult = new AddCartResult();
        if (user_info != null && !"".equals(user_info)) {
            BsShoppingCart bsShoppingCart = new BsShoppingCart();
            bsShoppingCart.setItemId(id);
            BsShoppingCart bsShoppingCart1 = addService.selectShopping(bsShoppingCart);
            if (id == bsShoppingCart1.getItemId()) {
                bsShoppingCart1.setNumber(bsShoppingCart1.getNumber() + 1);
                addService.updateShopping(bsShoppingCart1);
                addCartResult.setResult(true);
                return addCartResult;
            } else {
                addService.addCart(bsShoppingCart1);
                addCartResult.setResult(true);
                return addCartResult;
            }
        }
        addCartResult.setResult(false);
        return addCartResult;
    }
}