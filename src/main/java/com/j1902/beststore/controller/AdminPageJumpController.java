package com.j1902.beststore.controller;

import com.github.pagehelper.PageInfo;
import com.j1902.beststore.modle.UpdateOrderFormInfo;
import com.j1902.beststore.pojo.BsOrderForm;
import com.j1902.beststore.service.*;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author zj
 * @version 1.0
 * @create 2019-06-22 10:31
 */
@Controller
@MapperScan("com.j1902.beststore.mapper")
public class AdminPageJumpController {

    @Autowired
    private AdminBsItemService itemService;

    @Autowired
    private AdminBsUserService userService;

    @Autowired
    private AdminBsShoppingRecordService shoppingRecordService;

    @Autowired
    private AdminBsEmailService emailService;

    @Autowired
    private AdminBsOrderFormService orderFormService;

    @RequestMapping("/toAdminIndex.back")
    public String toAdminIndex(Map<String, Object> map,@RequestParam(defaultValue = "1") int pageNum) {
        try {
            int itemsCount = itemService.getAllItems().size();
            map.put("ITEMS_COUNT", itemsCount);
            int usersCount = userService.getCountOfBsUsers();
            map.put("USERS_COUNT", usersCount);
            int recordsCount = shoppingRecordService.getCountOfAll();
            map.put("RECORDS_COUNT", recordsCount);
            int emailsCount = emailService.getCountOfAllEmails();
            map.put("EMAILS_COUNT", emailsCount);
            PageInfo all = shoppingRecordService.getAll(pageNum, 5);
            map.put("ALL_RECORDS", all);
            return "admin/admin-index";
        } catch (Exception e) {
            return "error/index";
        }
    }

    @RequestMapping("/toOrderForm.back")
    public String toOrderForm(Map<String, Object> map, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        try {
            PageInfo allOrderForms = orderFormService.getAllOrderForms(pageNum, pageSize);
            map.put("ALL_ORDER_FORMS", allOrderForms);
            return "admin/order-form";
        } catch (Exception e) {
            return "error/index";
        }
    }

    @RequestMapping("/updateOrderFormState.back")
    public String updateOrderFormState(UpdateOrderFormInfo updateOrderFormInfo,@RequestParam(defaultValue = "1")int pageNum) {
        try {
            if (updateOrderFormInfo != null) {
                List<Integer> ids = updateOrderFormInfo.getIds();
                List<BsOrderForm> bsOrderForms = updateOrderFormInfo.getBsOrderForms();
                if (ids.size() > 0 && bsOrderForms.size() > 0) {
                    for (Integer integer : ids) {
                        for (BsOrderForm bsOrderForm : bsOrderForms) {
                            if (integer == bsOrderForm.getId()) {
                                bsOrderForm.setState("2");
                                orderFormService.setOrderFormState(bsOrderForm);
                            }
                        }
                    }
                }
                return "redirect:/toOrderForm.back?pageNum=" + pageNum;
            }
            return "redirect:/toOrderForm.back?pageNum=" + pageNum;
        } catch (Exception e) {
            return "error/index.back";
        }
    }

    @RequestMapping("/deleteOrderForm.back")
    public String deleteOrderForm(Integer id,@RequestParam(defaultValue = "1")int pageNum) {
        try {
            orderFormService.removeItem(id);
            return "redirect:/toOrderForm.back?pageNum=" + pageNum;
        } catch (Exception e) {
            return "error/index";
        }
    }



    @RequestMapping("/toAdminAddItem.back")
    public String toAdminAddItem() {
        return "admin/admin-add-item";
    }

    @RequestMapping("/toAdminUser.back")
    public String toAdminUser() {
        return "admin/admin-user";
    }

    @RequestMapping("/toEmail")
    public String toEmail() {
        return "email";
    }

    @RequestMapping("/toShortCodes")
    public String toShortCodes() {
        return "short-codes";
    }

    @RequestMapping("/toErrorIndex")
    public String toErrorIndex() {
        return "error/index";
    }

    @RequestMapping("/adminLogout")
    public String adminLogout() {
        return "redirect:toIndex";
    }
}
