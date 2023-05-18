package com.coco;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.coco.mapper")
@EnableScheduling

public class CocoLibApplication {

    public static void main(String[] args) {
        SpringApplication.run(CocoLibApplication.class, args);
    }

}
