package com.j1902.beststore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductsController {
    @RequestMapping("/toProducts")
    public String toProducts(){
        return "products";
    }
}
