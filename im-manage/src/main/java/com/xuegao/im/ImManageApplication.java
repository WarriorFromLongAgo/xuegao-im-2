package com.xuegao.im;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * <br/> @PackageName：com.xuegao.im.controller
 * <br/> @ClassName：ImManageApplication
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/17 20:03
 */
@SpringBootApplication(
        scanBasePackages = {
                "com.xuegao.im.config",
                "com.xuegao.im.service",
                "com.xuegao.im.autoconfig",
                "com.xuegao.im.controller",
                "com.xuegao.im.mvc",
                "com.xuegao.im.manager"
        }
)
@MapperScan(value = "com.xuegao.im.mapper")
public class ImManageApplication {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(ImManageApplication.class, args);

        // final ServerLauncherImpl sli = new ServerLauncherImpl();
        // sli.startup();
        // Runtime.getRuntime().addShutdownHook(new Thread() {
        //     @Override
        //     public void run() {
        //         sli.shutdown();
        //     }
        // });
    }
}