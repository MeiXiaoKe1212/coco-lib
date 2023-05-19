package com.coco.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.coco.domain.AutoGetseatUsers;
import com.coco.domain.VerifyCode;
import com.coco.global.Global;
import com.coco.service.GetSeatService;
import com.coco.service.IAutoGetseatUsersService;
import com.coco.service.IVerifyCodeService;
import com.coco.webDriver.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author coco
 * @create 2023/5/17
 */
@Service("autoGetSeat")
@Slf4j
public class GetSeatServiceImpl implements GetSeatService {

    @Resource
    private WebDriverManager webDriverManager;

    @Resource
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Resource
    private IAutoGetseatUsersService iAutoGetseatUsersService;

    @Resource
    private IVerifyCodeService iVerifyCodeService;

    @Override
    public void refreshParameters() {
        // 从数据库加载所有信息到Global中

    }

    @Override
    public boolean saveParameter(AutoGetseatUsers user) {
        //region 查询code是否有误
        VerifyCode codeDB = iVerifyCodeService.getOne(new LambdaQueryWrapper<VerifyCode>().eq(VerifyCode::getCode, user.getCode()));
        if (Objects.isNull(codeDB)) {
            return false;
        }
        //endregion

        //region 查看数据是否重复
        long count = iAutoGetseatUsersService.count(new LambdaQueryWrapper<AutoGetseatUsers>().eq(AutoGetseatUsers::getPhone, user.getPhone()));
        if (count > 0) {
            return false;
        }
        //endregion

        //region 保存数据到数据库中
        return iAutoGetseatUsersService.save(user);
        //endregion
    }

    /**
     * 定时方法，开始为所有参数进行抢座
     */
    @Override
    @Scheduled(cron = "0 0 7 * * ?")
    public void startGetSeats() {
        List<AutoGetseatUsers> list = iAutoGetseatUsersService.list();
        for (AutoGetseatUsers user : list) {
            threadPoolTaskExecutor.execute(() -> {
                getOneSeat(user);
            });
        }
    }

    /**
     * 单条参数抢座
     */
    @Override
    public void getOneSeat(AutoGetseatUsers user) {
        //region 获取驱动
        //windows版本：
        ChromeDriver driver = new ChromeDriver();
        try {
            driver = webDriverManager.getWebDriver();
        } catch (Exception e) {
            log.error("获取webdriver实例失败\n{}", e.getMessage());
        }
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10L));
        //endregion

        //region 获取参数信息
        //1. 学习通账号和密码
        String phone = user.getPhone();
        String password = user.getPassword();
        //2. 书库信息
        String shuKu = user.getShuku();
        //3. 预约时间
        String startTime = user.getStartTime();
        String endTime = user.getEndTime();
        //4. 座位信息
        String seatNum = user.getSeatNum();

        // 选择书库
        String shuKuPath = Global.map.get(Global.SHUKU_DATA).get(shuKu);
        // 选择时间
        String startTimePath = Global.map.get(Global.TIME_DATA).get(startTime);
        String endTimePath = Global.map.get(Global.TIME_DATA).get(endTime);
        // 选择座位
        String seatPath = "//*[@id=\"content-container\"]/div[" + seatNum + "]";
        // 提交
        String submitBtnPath = "/html/body/div[1]/div[4]/p";
        //endregion

        long start = System.currentTimeMillis();
        driver.get("https://office.chaoxing.com/front/third/apps/seat/list?deptIdEnc=e23eb03ef41afd60");
        Set<Cookie> cookies = driver.manage().getCookies();
        if (!cookies.isEmpty()) {
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
        }
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"phone\"]"))).sendKeys(phone);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"pwd\"]"))).sendKeys(password);
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"loginBtn\"]"))).click();
        // 选择书库
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(shuKuPath))).click();
        // 选择时间
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(startTimePath))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(endTimePath))).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div/div[6]/div[1]/span[3]"))).click();

        // 选择座位
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(seatPath))).click();
        // 提交
        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath(submitBtnPath))).click();

        long end = System.currentTimeMillis();
        double elapsedTime = (end - start) / 1000.0;
        log.debug(driver.hashCode() + "号实例运行时间：" + elapsedTime + "秒");
        driver.close();
        webDriverManager.returnWebDriver(driver);
    }

}
