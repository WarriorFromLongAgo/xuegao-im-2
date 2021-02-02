package com.xuegao.im.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br/> @PackageName：com.sf.edu.config
 * <br/> @ClassName：MyBatisPlusConfig
 * <br/> @Description：
 * <br/> @author：80004960
 * <br/> @date：2020/10/29 11:41
 */
@Configuration
public class MyBatisPlusConfig {

    /**
     * 配置mybatis-plus 分页查件
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}