package com.riven.service_admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.riven.common_utils.R;
import com.riven.service_admin.entity.AdminInfo;
import com.riven.service_admin.entity.vo.AdminLogin;
import com.riven.service_admin.service.AdminInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;



/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author riven
 * @since 2022-11-15
 */
@RestController
@RequestMapping("/service_admin")
@CrossOrigin
public class AdminLoginController {

    @Autowired
    private AdminInfoService adminInfoService;

    @PostMapping("login")
    public R login(@RequestBody(required = true) AdminLogin loginUser,
                   HttpSession session) {
        QueryWrapper<AdminInfo> wrapper = new QueryWrapper<>();
        String username = loginUser.getUsername();
        String password = loginUser.getPassword();

        if (!StringUtils.isEmpty(username)) {
            wrapper.eq("admin_account", username);
        }
        if (!StringUtils.isEmpty(password)) {
            wrapper.eq("admin_password", password);
        }
        AdminInfo admin = adminInfoService.getOne(wrapper);
        if (admin!=null){
            session.setAttribute("current_user", admin);
            return R.ok().data("token", "token");
        }else {
            return R.error().message("账号或密码错误！");
        }

    }

    @GetMapping("info")
    public R info(HttpSession session) {
        AdminInfo current_user = (AdminInfo) session.getAttribute("current_user");
        System.out.println(current_user);
        if(current_user!=null){
            return R.ok().data("userInfo", current_user);
        }else {
            return R.error().message("账号异常！");
        }
    }
}

