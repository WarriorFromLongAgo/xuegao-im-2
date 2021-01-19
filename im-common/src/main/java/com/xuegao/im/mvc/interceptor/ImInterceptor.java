package com.xuegao.im.mvc.interceptor;

import com.xuegao.im.mvc.CORSFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <br/> @PackageName：com.xuegao.im.mvc.interceptor
 * <br/> @ClassName：ImInterceptor
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/19 21:08
 */
@Configuration
public class ImInterceptor implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new CORSFilter()).addPathPatterns("/**");
    }
}