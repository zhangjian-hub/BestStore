package com.j1902.beststore.controller;

import com.j1902.beststore.modle.GetShoppingId;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.BsItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class GetIdController {
    @Autowired
    private BsItemService bsItemService;
    @RequestMapping("/toGteId")
    @ResponseBody
    public GetShoppingId getId(BsItem bsItem){
        GetShoppingId getShoppingId=new GetShoppingId();
        BsItem bsItem2 = bsItemService.toCommodityDetail(bsItem);
        if (bsItem2==null){
            getShoppingId.setResult(false);
            return getShoppingId;
        }
        getShoppingId.setId(bsItem2.getId());
        return getShoppingId;
    }
}
