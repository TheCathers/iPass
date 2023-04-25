package com.riven.service_admin.service.impl;

import com.riven.service_admin.entity.UserInfo;
import com.riven.service_admin.mapper.UserInfoMapper;
import com.riven.service_admin.service.UserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author riven
 * @since 2022-11-15
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
