package com.xuegao.im.autoconfig;

import com.xuegao.im.util.SpringCtxUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自定义配置SpringCtxUtil
 * <p>
 * 需要使用时,在@ComponentScan中配置此类或com.sf.cr.util.autoconfig.ctx路径,否则不可使用SpringCtxUtil<br/>
 * 单独排除方式:@ComponentScan(excludeFilters=@ComponentScan.Filter(type=FilterType.ASSIGNABLE_TYPE,classes={SpringCtxUtilConfig.class}))
 * </p>
 * 
 * @author 80003093/tanquanfang
 * @date 2019/03/28
 */
@Configuration
@ConditionalOnClass(ApplicationContext.class)
public class SpringCtxUtilConfig {

    @Bean
    @ConditionalOnMissingBean
    public SpringCtxUtil springCtxUtil(ApplicationContext applicationContext) {
        SpringCtxUtil instance = SpringCtxUtil.getInstance();
        instance.setApplicationContext(applicationContext);
        return instance;
    }
}