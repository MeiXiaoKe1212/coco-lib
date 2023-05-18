package com.coco.controller;

import com.coco.domain.AutoGetseatUsers;
import com.coco.service.GetSeatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author coco
 * @create 2023/5/17
 */
@RestController
@RequestMapping("/seat")
public class SeatController {

    @Resource
    private GetSeatService getSeatService;

    @GetMapping("/test")
    public void test() {
        getSeatService.startGetSeats();
    }

    @PostMapping("/saveParameter")
    public Map<String, Boolean> saveParameter(@RequestBody AutoGetseatUsers user) {
        Map<String, Boolean> resp = new HashMap<>();
        boolean saveSuccess = getSeatService.saveParameter(user);
        if (saveSuccess) {
            resp.put("success", true);
        } else {
            resp.put("success", false);
        }
        return resp;
    }

}
