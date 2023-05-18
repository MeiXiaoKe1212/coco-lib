package com.coco.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coco.domain.AutoGetseatUsers;
import com.coco.mapper.AutoGetseatUsersMapper;
import com.coco.service.IAutoGetseatUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author ruoyi
 * @date 2023-05-17
 */
@Service
public class AutoGetseatUsersServiceImpl extends ServiceImpl<AutoGetseatUsersMapper, AutoGetseatUsers> implements IAutoGetseatUsersService {
    @Resource
    private AutoGetseatUsersMapper autoGetseatUsersMapper;


}
