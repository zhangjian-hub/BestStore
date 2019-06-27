package com.j1902.beststore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.ItemServiceLjy;
import net.sf.jsqlparser.statement.select.Fetch;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class ProductsControllerLjy {
    @Autowired
    private ItemServiceLjy itemService;

    @RequestMapping("/toProducts.html")
    public String toForgotPassword( Map<String, Object> map) {
        PageHelper.startPage(1,6);
        List<BsItem> bsItems = itemService.selectAll();
        PageInfo info = new PageInfo(bsItems,6);
        List<BsItem> b = info.getList();

        List<BsItem> a = new ArrayList();

        a.add(b.get(0));
        a.add(b.get(2));
        a.add(b.get(3));

        System.out.println("a = " + a);
        System.out.println("bsItems = " + bsItems);
        System.out.println("info = " + info);

        List<Integer> list = new ArrayList();
        for (int i = 1;i <info.getPages()+1;i++){
            list.add(i);
        }
        System.out.println("list = " + list);
        map.put("INFO",info);
        map.put("BSITEMS", b);
        map.put("LIST",list);
        map.put("A",a);
        return "products";
    }

    @RequestMapping("/toProducts")
    public String products(HttpServletRequest req, Map<String, Object> map) {
        String suitablePeople = req.getParameter("suitablePeople");
        System.out.println("suitablePeople = " + suitablePeople);
        String type = req.getParameter("type");
        System.out.println("type = " + type);

        BsItem bsItem = new BsItem();
        bsItem.setSuitablePeople(suitablePeople);
        bsItem.setType(type);
        Integer pageNum = Integer.valueOf(req.getParameter("pageNum"));
        System.out.println("pageNum = " + pageNum);

       PageHelper.startPage(pageNum,6);

        List<BsItem> bsItems = itemService.selectAllGroupByName(bsItem);

        PageInfo info = new PageInfo(bsItems,6);
        List<BsItem> b = info.getList();
        List<BsItem> c = itemService.selectAll();
        List<BsItem> a = new ArrayList();

        a.add(c.get(0));
        a.add(c.get(2));
        a.add(c.get(3));

        System.out.println("bsItems = " + bsItems);
        System.out.println("info = " + info);

        List<Integer> list = new ArrayList();
        for (int i = 1;i <info.getPages()+1;i++){
            list.add(i);
        }
        System.out.println("list = " + list);
        map.put("INFO",info);
        map.put("BSITEMS", b);
        map.put("suitablePeople",suitablePeople);
        map.put("type",type);
        map.put("LIST",list);
        map.put("A",a);
//        session.setAttribute("BSITEMS",bsItems);
        return "products";
    }


}
