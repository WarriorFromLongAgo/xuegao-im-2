package com.xuegao.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <br/> @PackageName：com.xuegao.im
 * <br/> @ClassName：ImServiceApplication
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/17 20:08
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.xuegao.im.config",
                "com.xuegao.im.service",
                "com.xuegao.im.autoconfig",
                "com.xuegao.im.controller",
                "com.xuegao.im.manager"
        }
)
@MapperScan(value = "com.xuegao.im.mapper")
public class ImServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(ImServiceApplication.class, args);
    }

}