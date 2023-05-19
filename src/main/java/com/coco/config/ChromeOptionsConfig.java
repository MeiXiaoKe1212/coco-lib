package com.coco.config;

import com.coco.agent.UserAgent;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author MXK
 * @create 2023/5/19
 */
@Slf4j
public class ChromeOptionsConfig {

    public static ChromeOptions getOptions() {
        String userDir = System.getProperty("user.dir");
        String driverPath = userDir + "/driver/windows/chromedriver.exe";
        log.debug(driverPath);
        System.setProperty("webdriver.chrome.driver", driverPath);
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless"); //无浏览器模式
        options.addArguments("--disable-gpu"); // 谷歌文档提到需要加上这个属性来规避bug
        options.addArguments("--disable-software-rasterizer"); //禁用3D软件光栅化器
        options.addArguments("--no-sandbox");// 为了让linux root用户也能执行
        // 优化参数
        options.addArguments("--disable-dev-shm-usage"); //解决在某些VM环境中，/dev/shm分区太小，导致Chrome失败或崩溃
        options.addArguments("blink-settings=imagesEnabled=false"); //禁止加图片,如果爬取图片的话,这个不能禁用
        options.addArguments("--disable-images");
        String tmpdir = System.getProperty("java.io.tmpdir");
        String dir = tmpdir + File.separator + "chrome_file_data_cache" + File.separator + new AtomicInteger(0).incrementAndGet();
        File file1 = new File(dir + File.separator + "data");
        if (file1.exists()) {
            file1.mkdirs();
        }
        File file2 = new File(dir + File.separator + "cache");
        if (file2.exists()) {
            file1.mkdirs();
        }
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--user-data-dir=" + file1.getAbsolutePath()); //解决打开页面出现data;空白页面情况,因为没有缓存目录
        options.addArguments("--disk-cache-dir=" + file2.getAbsolutePath()); //指定Cache路径
        options.addArguments("--disable-plugins"); //禁用插件,加快速度
        options.addArguments("--disable-extensions"); //禁用扩展
        options.addArguments("--incognito"); //无痕模式
        options.addArguments("--disable-popup-blocking"); //关闭弹窗拦截
        options.addArguments("--ignore-certificate-errors"); //  禁现窗口最大化
        options.addArguments("--allow-running-insecure-content");  //关闭https提示 32位
        options.addArguments("--disable-infobars");  //禁用浏览器正在被自动化程序控制的提示  ,但是高版本不生效
        options.addArguments("window-size=" + 1920 + "," + 1080);//无浏览器模式-最大化窗口  ,防止有些元素被隐藏
        options.addArguments("--user-agent=" + UserAgent.getUserAgentWindows());//随机设置请求头
        return options;
    }
}
