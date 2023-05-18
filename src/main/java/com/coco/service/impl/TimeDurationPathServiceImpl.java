package com.coco.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coco.domain.TimeDurationPath;
import com.coco.mapper.TimeDurationPathMapper;
import com.coco.service.ITimeDurationPathService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * TimeDurationPathServiceImpl
 *
 * @author coco
 * @date 2023-05-17
 */
@Service
public class TimeDurationPathServiceImpl extends ServiceImpl<TimeDurationPathMapper, TimeDurationPath> implements ITimeDurationPathService {
    @Resource
    private TimeDurationPathMapper timeDurationPathMapper;


}
