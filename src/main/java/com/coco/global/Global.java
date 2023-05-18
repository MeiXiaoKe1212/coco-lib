package com.coco.global;

import com.coco.domain.Shuku;
import com.coco.domain.TimeDurationPath;
import com.coco.service.IShukuService;
import com.coco.service.ITimeDurationPathService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Global 全局维护数据内存
 *
 * @author coco
 * @date 2023-05-17
 */
@Component
@Slf4j
public class Global {

    public static ConcurrentHashMap<String, ConcurrentHashMap<String, String>> map = new ConcurrentHashMap<>();

    public static final String SHUKU_DATA = "shukuData";
    public static final String TIME_DATA = "timeData";

    @Resource
    private IShukuService shukuService;

    @Resource
    private ITimeDurationPathService timeDurationPathService;

    /**
     * 服务启动自动加载抢座用户信息
     */
    @PostConstruct
    private void init() {
        try {
            // 获取书库信息
            List<Shuku> shukuList = shukuService.list();
            ConcurrentHashMap<String, String> shukuData = new ConcurrentHashMap<>();
            shukuList.forEach(
                    item -> {
                        shukuData.put(item.getName(), item.getHtmlPath());
                    }
            );
            map.put(SHUKU_DATA, shukuData);
            // 获取时间信息
            List<TimeDurationPath> timeDurationPathList = timeDurationPathService.list();
            ConcurrentHashMap<String, String> timeData = new ConcurrentHashMap<>();
            timeDurationPathList.forEach(
                    item -> {
                        timeData.put(item.getTimeDuration(), item.getHtmlPath());
                    }
            );
            map.put(TIME_DATA, timeData);
        } catch (Exception e) {
            log.error("配置加载失败，请检查" + e.getMessage());
        }
    }
}
