package com.j1902.beststore.controller;

import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.BsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class BsItemController {
    @Autowired
    private BsItemService bsItemService;
    @RequestMapping("/toSingle")
    public String toSingle( Map<String, Object> map ,BsItem bsItem ){
        List<BsItem> bsItems = bsItemService.toCommodityDetails(bsItem);
        BsItem bsItem1 = bsItemService.toCommodityDetail(bsItem);
        List<String> color=new ArrayList<>();
        List<String> size=new ArrayList<>();
        List<String> image=new ArrayList<>();
        for (BsItem item : bsItems) {
            String color1 = item.getColor();
            String size1 = item.getSize();
            String image1=item.getImage();
            if (!color.contains(color1)){
                color.add(color1);}
            if (!size.contains(size1)){
                size.add(size1);}
            if (!image.contains(image1)){
                image.add(image1);}
        }
        map.put("BSITEM_INFO1",bsItem1);
        map.put("BSITEMS_INFO",bsItems);
        map.put("COLOR_INFO",color);
        map.put("SIZE_INFO",size);
        map.put("IMAGE_INFO",image);
        return "single";
    }
}
