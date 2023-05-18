package com.ruoyi.web.controller.autogetseat;

import com.ruoyi.common.annotation.Anonymous;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.domain.AutoGetseatUsers;
import com.ruoyi.service.GetSeatService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @author MXK
 * @create 2023/5/17
 */
@RestController
@RequestMapping("/seat")
@Anonymous
public class SeatController {

    @Resource
    private GetSeatService getSeatService;

    @GetMapping("/test")
    public void test() {
        getSeatService.startGetSeats();
    }

    @PostMapping("/saveParameter")
    public AjaxResult saveParameter(@RequestBody AutoGetseatUsers user) {
        AjaxResult ajax = new AjaxResult();
        boolean saveSuccess = getSeatService.saveParameter(user);
        if (saveSuccess) {
            ajax.put("success", true);
        }else {
            ajax.put("success", false);
        }
        return ajax;
    }

}
