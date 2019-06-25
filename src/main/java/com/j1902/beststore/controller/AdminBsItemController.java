package com.j1902.beststore.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.State;
import com.j1902.beststore.modle.UpdateItemsInfo;
import com.j1902.beststore.pojo.BsItem;
import com.j1902.beststore.service.BsItemService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:02
 */

@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminBsItemController {
    @Autowired
    private BsItemService itemService;

    @RequestMapping("/toAdminItems.back")
    public String toAdminItems(Map<String, Object> map, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<BsItem> allItems = itemService.getAllItems();
        PageInfo<BsItem> pageInfo = new PageInfo<>(allItems);
        map.put("PAGE_INFO", pageInfo);
        return "admin/admin-items";
    }

    @RequestMapping("/addItem.back")
    public String addItem(Map<String,Object> map, BsItem item, @RequestParam(value = "file") MultipartFile file, HttpServletRequest request) {
        System.out.println("item = " + item);

        if (file.isEmpty()) {
            System.out.println("文件为空空");
        }
        String fileName = file.getOriginalFilename();  // 文件名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));  // 后缀名
        String filePath = "D://temp-rainy//"; // 上传后的路径
        fileName = UUID.randomUUID() + suffixName; // 新文件名
        File dest = new File(filePath + fileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(dest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filename = "/temp-rainy/" + fileName;
        System.out.println("filename = " + filename);

        item.setImage(filename);
        item.setSalesVolume(0);
        itemService.addItem(item);
        State state = new State();
        state.setState(true);
        map.put("ADD_ITEM_STATE", true);
        return "admin/admin-add-item";
    }

    @RequestMapping("/toOrderForm.back")
    public String toOrderForm() {

        return "admin/order-form";
    }



    @RequestMapping("/updateItem.back")
    public String updateItem(UpdateItemsInfo updateItemsInfo) {
        if (updateItemsInfo.getItems() != null && updateItemsInfo.getIds() != null) {
            for (Integer id : updateItemsInfo.getIds()) {
                for (BsItem item : updateItemsInfo.getItems()) {
                    if (id == item.getId()) {
                        itemService.setItem(item);
                    }
                }
            }
        }
        return "redirect:toAdminItems.back";
    }

    @RequestMapping("/deleteItem.back")
    public String deleteItem(Integer id) {
        itemService.removeItem(id);
        return "redirect:toAdminItems.back";
    }
}
