package com.coco.utils;

import com.coco.agent.UserAgent;
import lombok.SneakyThrows;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.io.File;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * ChromeDriverUtil
 */
public class ChromeDriverUtil {
    //文件版本,防止多线程缓存文件和用户文件共享,导致创建错误
    private static final AtomicInteger fileSerial = new AtomicInteger(0);
    private ChromeDriver driver;

    public ChromeDriverUtil(String path, boolean pd, boolean img) {
        init(path, pd, img);
    }

    @SneakyThrows
    private void init(String path, boolean pd, boolean img) {
        System.setProperty("webdriver.chrome.driver", path);
        ChromeOptions options = new ChromeOptions();
        if (!pd) {
            options.addArguments("--headless"); //无浏览器模式
        }
        options.addArguments("--disable-gpu"); // 谷歌文档提到需要加上这个属性来规避bug
        options.addArguments("--disable-software-rasterizer"); //禁用3D软件光栅化器
        options.addArguments("--no-sandbox");// 为了让linux root用户也能执行
        // 优化参数
        options.addArguments("--disable-dev-shm-usage"); //解决在某些VM环境中，/dev/shm分区太小，导致Chrome失败或崩溃
        if (img) {
            options.addArguments("blink-settings=imagesEnabled=false"); //禁止加图片,如果爬取图片的话,这个不能禁用
            options.addArguments("--disable-images");
        }

        String tmpdir = System.getProperty("java.io.tmpdir");
        String dir = tmpdir + File.separator + "chrome_file_data_cache" + File.separator + fileSerial.incrementAndGet();
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

        if (!pd) {
            //无浏览器模式-最大化窗口  ,防止有些元素被隐藏
            options.addArguments("window-size=" + 1920 + "," + 1080);
        }
        //随机设置请求头
        options.addArguments("--user-agent=" + UserAgent.getUserAgentWindows());
        proxy(options, false); //设置代理 ,true 开启代理
        driver = new ChromeDriver(options);//实例化
        if (pd) {
            driver.manage().window().maximize(); //界面的方式, 最大化窗口, 防止有些元素被隐藏,无界面就不要使用了
        }
        //当我们去定位页面元素时，如果元素没有找到，不会立即抛出异常，而是周期性地（通常为 0.5s）去重新寻找，直到该元素找到或者超过最大等待时间才结束 ,超时后就报错NoTouchElementException
        //当我们使用implicitly_wait()时，如果想要定位的元素已经找到，但是它的内容（如文本内容，属性等）没有加载出来，此时隐式等待无效，仍会直接抛出NoSuchElementException异常，这也是为什么我们很多时候仍需要使用time.sleep()的原因。
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    //无头模式,不加载图片
    public static ChromeDriverUtil buildHide(String path) {
        return new ChromeDriverUtil(path, false, true);
    }

    //无头模式,加载图片
    public static ChromeDriverUtil buildHideImg(String path) {
        return new ChromeDriverUtil(path, false, false);
    }

    //显示游览器 ,全功能
    public static ChromeDriverUtil build(String path) {
        return new ChromeDriverUtil(path, true, false);
    }

    public ChromeDriver getDriver() {
        return driver;
    }

    //强制等待 代码在执行到某个位置时强制等待一段时间
    @SneakyThrows
    public void sleep(long ms) {
        Thread.sleep(ms);
    }

    // 显示等待,是为了解决隐式等待遗留的问题,比如元素显示了,但是内部的文本没有显示出来,可能文本是通过ajax异步的会比较慢
//    public WebElement wait(int seconds, ExpectedCondition<WebElement> expectedCondition) {
//        WebDriverWait webDriverWait = new WebDriverWait(driver, seconds);
//        //返回null或者false,等待500毫秒继续尝试,直到过期
//        WebElement until = webDriverWait.until(expectedCondition);
//
//        return until;
//    }

    //自行扩展, 从接口中读取,或者从文件中读取都行
    private void proxy(ChromeOptions options, boolean pd) {
        if (pd) {
            String prox = "101.200.127.149:" + 3129;
            Proxy p = new Proxy();
            p.setHttpProxy(prox);//http
//        p.setFtpProxy(prox); //ftp
//        p.setSslProxy(prox);//ssl
//        p.setSocksProxy(prox); //SOCKS
//        p.setSocksUsername("");
//        p.setSocksPassword("");

            options.setProxy(p);
        }
    }


}


