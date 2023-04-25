package com.riven.service_admin.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.riven.common_utils.R;
import com.riven.service_admin.entity.CardInfo;
import com.riven.service_admin.entity.vo.CardQuery;
import com.riven.service_admin.service.CardInfoService;
import com.riven.service_admin.service.impl.CardInfoServiceImpl;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

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
public class CardInfoController {
    @Autowired
    private CardInfoService cardInfoService;

    @DeleteMapping("removeDataById/{id}")
    public R removeDataById(@PathVariable Integer id) {
        boolean flag = cardInfoService.removeById(id);
        if (flag){
            return R.ok().message("删除成功！");
        }else {
            return R.error().message("删除失败！");
        }
    }

    //卡入库
    @GetMapping("addCardInfo/{prefix}/{from}/{to}")
    public R addCardInfo(@PathVariable String prefix,
                         @PathVariable Integer from,
                         @PathVariable Integer to) {
        for (int i = from; i <= to; i++) {
            CardInfo newCard = new CardInfo();
            newCard.setCardNumber(prefix + i);
            newCard.setState(0);
            System.out.println(newCard);
            cardInfoService.save(newCard);
        }
        return R.ok().message("添加成功！");
    }

    //条件查询分页方法
    @ApiOperation(value = "条件查询分页方法")
    @PostMapping("pageCardCondition/{current}/{limit}")
    public R pageCardCondition(@PathVariable Long current,
                               @PathVariable Long limit,
                               @RequestBody(required = false) CardQuery cardQuery) {
        //创建page
        Page<CardInfo> pageCondition = new Page<>(current, limit);
        //QueryWrapper,构建
        QueryWrapper<CardInfo> wrapper = new QueryWrapper<>();
        //多条件组合查询，动态sql
        String cardNumber = cardQuery.getCardNumber();
        Integer state = cardQuery.getState();
        String userId = cardQuery.getUserId();
        String receiveId = cardQuery.getReceiveId();
        //判断条件是否为空，拼接条件
        if (!StringUtils.isEmpty(cardNumber)) {
            wrapper.likeRight("card_number", cardNumber);
        }
        if (!StringUtils.isEmpty(state)) {
            wrapper.like("state", state);
        }
        if (!StringUtils.isEmpty(userId)) {
            wrapper.likeRight("user_id", userId);
        }
        if (!StringUtils.isEmpty(receiveId)) {
            wrapper.likeRight("receive_id", receiveId);
        }

        wrapper.orderByAsc("card_number");

        //调用方法，实现分页查询
        cardInfoService.page(pageCondition, wrapper);

        long total = pageCondition.getTotal();//获取总记录数
        List<CardInfo> records = pageCondition.getRecords();//获取分页后的list集合
        HashMap<String, Object> map = new HashMap<>();
        map.put("total", total);
        map.put("rows", records);
        return R.ok().data(map);
    }

}

