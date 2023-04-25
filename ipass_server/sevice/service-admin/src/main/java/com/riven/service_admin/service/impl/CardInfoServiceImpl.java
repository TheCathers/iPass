package com.riven.service_admin.service.impl;

import com.riven.service_admin.entity.CardInfo;
import com.riven.service_admin.mapper.CardInfoMapper;
import com.riven.service_admin.service.CardInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author riven
 * @since 2022-11-15
 */
@Service
@Transactional
public class CardInfoServiceImpl extends ServiceImpl<CardInfoMapper, CardInfo> implements CardInfoService {

}
