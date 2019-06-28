package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.MyProfileItemFull;
import com.j1902.beststore.modle.ShoppingCartResult;
import com.j1902.beststore.modle.ShoppingRecordResult;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.pojo.BsOrderForm;
import com.j1902.beststore.pojo.BsShoppingRecord;
import com.j1902.beststore.pojo.BsUser;
import com.j1902.beststore.service.BsMyProfileService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class MyProfileController {
    @Autowired
    BsMyProfileService bsMyProfileService;

    //    去个人中心
    @RequestMapping("/toMyProfile")
    public String toMyProfile(HttpServletRequest request, Integer pageNum, Integer pageNum1, Map<String, Object> map) {
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
            if (pageNum1 == null) {
                pageNum1 = 1;
            }
//        订单表的分页
            PageInfo<BsOrderForm> pageInfo = bsMyProfileService.pageBsOrderForm(id, pageNum, 3);
            map.put("PAGEINFO", pageInfo);
            List<MyProfileItemFull> myProfileItemFulls = new ArrayList<>();
            for (BsOrderForm bsOrderForm : pageInfo.getList()) {
                Integer itemId = bsOrderForm.getItemId();
                MyProfileItemFull myProfileItemFull = new MyProfileItemFull();
                BsItem bsItem = bsMyProfileService.getItem(itemId);
                myProfileItemFull.setId(bsOrderForm.getId());
                myProfileItemFull.setOrderId(bsOrderForm.getOrderId());
                myProfileItemFull.setImg(bsItem.getImage());
                myProfileItemFull.setStatus(bsOrderForm.getState());
                myProfileItemFulls.add(myProfileItemFull);
            }
//        记录表的分页
            PageInfo<BsShoppingRecord> pageInfo1 = bsMyProfileService.pageShoppingRecord(id, pageNum1, 3);
            map.put("PAGEINFO1", pageInfo1);
            List<ShoppingRecordResult> shoppingRecordResults = new ArrayList<>();
            for (BsShoppingRecord bsShoppingRecord : pageInfo1.getList()) {
                String itemInfo = bsShoppingRecord.getItemInfo();
                Date createTime = bsShoppingRecord.getCreateTime();
                String[] split = itemInfo.split(",");
                String name = split[0];
                String img = split[1];
                ShoppingRecordResult shoppingRecordResult = new ShoppingRecordResult();
                shoppingRecordResult.setName(name);
                shoppingRecordResult.setImg(img);
                shoppingRecordResult.setTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(createTime));
                shoppingRecordResults.add(shoppingRecordResult);
            }
            map.put("ITEM_LIST_PROFILE", myProfileItemFulls);
            map.put("ITEM_LIST_SHOPPING", shoppingRecordResults);
            return "myProfile";
        } catch (Exception e) {
            return "error/index";
        }
    }

    //    确认收货
    @RequestMapping("/confirmReceipt")
    @ResponseBody
    public ShoppingCartResult confirmReceipt(Integer id) {
//        查询订单表
        BsOrderForm bsOrderForm = bsMyProfileService.getBsOrderForm(id);
        Integer itemId = bsOrderForm.getItemId();
        Integer userId = bsOrderForm.getUserId();
//        查询商品信息
        BsItem item = bsMyProfileService.getItem(itemId);
//        准备操作购物记录表
        BsShoppingRecord bsShoppingRecord = new BsShoppingRecord();
        bsShoppingRecord.setUserId(userId);
        bsShoppingRecord.setItemInfo(item.getName() + "," + item.getImage() + "," + item.getType() + "," + item.getColor() + "," + item.getSize() + "," + item.getPrice());
        bsShoppingRecord.setCreateTime(new Date());
        boolean b = bsMyProfileService.addBsShoppingRecord(bsShoppingRecord);
        ShoppingCartResult shoppingCartResult = new ShoppingCartResult();
        if (b) {
            boolean b1 = bsMyProfileService.removeBsOrderForm(id);
            if (b1) {
                shoppingCartResult.setReslut(true);
                return shoppingCartResult;
            }
        }
        shoppingCartResult.setReslut(false);
        return shoppingCartResult;
    }
}
