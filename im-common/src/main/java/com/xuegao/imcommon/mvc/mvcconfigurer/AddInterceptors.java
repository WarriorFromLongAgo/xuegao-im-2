package com.xuegao.imcommon.mvc.mvcconfigurer;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.xuegao.imcommon.mvc.filter.XssFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

/**
 * <br/> @PackageName：com.cherrys.schooldemo.mvc.mvcconfigurer
 * <br/> @ClassName：AddInterceptor
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/16 11:31
 */
@Configuration
public class AddInterceptors implements WebMvcConfigurer {

    // @Autowired
    // private RedisLimitInterceptor redisLimitInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // InterceptorRegistration loginlerInterceptor = registry.addInterceptor(new LoginlerInterceptor());
        // /**
        //  * 添加拦截的路径
        //  * /为根路径
        //  * /*为一级路径
        //  * /** 为所有路径包括多级
        //  */
        // loginlerInterceptor.addPathPatterns("/**");
        // // 排除不拦截的，包括自己登录的页面不用拦截
        // loginlerInterceptor.excludePathPatterns("/login");
        // loginlerInterceptor.excludePathPatterns("/user/handle");
        //
        // List<String> excludePath = new ArrayList<>();
        // // 排除拦截，除了注册登录(此时还没token)，其他都拦截
        // // 注册
        // excludePath.add("/login");
        // // 静态资源
        // excludePath.add("/static/**");
        // // 静态资源
        // excludePath.add("/assets/**");

        // registry.addInterceptor(new TokenInterceptor())
        //         .addPathPatterns("/**")
        //         .excludePathPatterns(excludePath);

        // registry.addInterceptor(redisLimitInterceptor)
        //         .addPathPatterns("/**");
    }

    // 配置静态资源路径
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 访问/swagger-ui.html找不到页面，原因是Swagger的页面是打在JAR中的。
        registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
        registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/**");
        // ico
        registry.addResourceHandler("/favicon.ico").addResourceLocations("classpath:/static/");
        // knife4j
        registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
    }

    // 重写父类提供的跨域请求处理的接口，跨域处理
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //添加映射路径
        registry.addMapping("/**")
                // 开放哪些ip、端口、域名的访问权限，星号表示开放所有域
                .allowedOrigins("*")
                // 是否允许发送Cookie信息
                .allowCredentials(true)
                // 开放哪些Http方法，允许跨域访问
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD")
                // 放行哪些原始域(头部信息) 允许HTTP请求中的携带哪些Header信息
                .allowedHeaders("*")
                //暴露哪些头部信息（因为跨域访问默认不能获取全部头部信息）
                .exposedHeaders("Header1", "Header2");
        //添加映射路径，“/**”表示对所有的路径实行全局跨域访问权限的设置
        // UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        // configSource.registerCorsConfiguration("/**", config);
    }

    /**
     * XssFilter. xss攻击过滤
     */
    @Bean
    public FilterRegistrationBean<XssFilter> filterXssRegistration() {
        FilterRegistrationBean<XssFilter> registration = new FilterRegistrationBean<>();
        registration.setFilter(new XssFilter());
        // 设定匹配的路径
        registration.addUrlPatterns("/*");
        // 设定加载的顺序
        registration.setOrder(0);
        return registration;
    }

    public static final String DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 配置消息转换器-- 优先fastjson.
     * @param converters the converters
     */
    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        // 定义一个FastJsonHttpMessageConverter转换消息的对象;
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        // 添加fastJson的配置信息，比如：是否要格式化返回的json数据;
        FastJsonConfig fastJsonConfig = new FastJsonConfig();
        fastJsonConfig.setSerializerFeatures(SerializerFeature.PrettyFormat, SerializerFeature.WriteDateUseDateFormat);
        fastJsonConfig.setDateFormat(DATETIME);
        // 支持媒体类型
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON_UTF8);
        fastMediaTypes.add(MediaType.TEXT_HTML);
        // 在convert中添加配置信息.
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(fastJsonConfig);
        // 将convert添加到converters当中 放到第一个 便于优先使用 以免使用到没配置的converter json化及requestBody反json化使用.
        converters.add(0, fastJsonHttpMessageConverter);
    }

}