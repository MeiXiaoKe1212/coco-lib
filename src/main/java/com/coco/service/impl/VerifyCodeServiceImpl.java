package com.coco.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coco.domain.VerifyCode;
import com.coco.mapper.VerifyCodeMapper;
import com.coco.service.IVerifyCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * VerifyCodeServiceImpl
 *
 * @author coco
 * @date 2023-05-17
 */
@Service
public class VerifyCodeServiceImpl extends ServiceImpl<VerifyCodeMapper, VerifyCode> implements IVerifyCodeService {
    @Resource
    private VerifyCodeMapper verifyCodeMapper;

}
