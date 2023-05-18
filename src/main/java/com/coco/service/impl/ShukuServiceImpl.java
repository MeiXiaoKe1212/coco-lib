package com.coco.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coco.domain.Shuku;
import com.coco.mapper.ShukuMapper;
import com.coco.service.IShukuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * ShukuServiceImpl
 *
 * @author coco
 * @date 2023-05-17
 */
@Service
public class ShukuServiceImpl extends ServiceImpl<ShukuMapper, Shuku> implements IShukuService {
    @Resource
    private ShukuMapper shukuMapper;

}
