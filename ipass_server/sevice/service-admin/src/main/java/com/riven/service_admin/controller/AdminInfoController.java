package com.riven.service_admin.controller;


import com.riven.common_utils.R;
import com.riven.service_admin.entity.AdminInfo;
import com.riven.service_admin.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author riven
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/service_admin")
@CrossOrigin
public class AdminInfoController {

    @Autowired
    private AdminInfoService adminInfoService;

    @GetMapping("findAll")
    public R findAllAdmin(){
//        List<UserInfoMap> admins = adminInfoService.UserInfo();
        List<AdminInfo> admins = adminInfoService.list(null);
        return R.ok().data("items",admins);
    }
}

