package com.coco.webDriver;

import com.coco.config.ChromeOptionsConfig;
import lombok.SneakyThrows;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.stereotype.Component;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author MXK
 * @create 2023/5/19
 */
@Component
public class WebDriverManager {

    private final BlockingQueue<ChromeDriver> webDriverQueue = new LinkedBlockingQueue<>();


    public WebDriverManager() {
        this.init();
    }

    @SneakyThrows
    private void init() {
        for (int i = 0; i < 10; i++) {
            webDriverQueue.offer(new ChromeDriver(ChromeOptionsConfig.getOptions()));
        }
    }

    public ChromeDriver getWebDriver() throws InterruptedException {
        return webDriverQueue.take();
    }

    public void returnWebDriver(ChromeDriver driver) {
        webDriverQueue.offer(driver);
    }

}
