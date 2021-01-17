package com.xuegao.im.util;

import com.xuegao.im.constant.SignConst;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;

public class SpringCtxUtil {

    private static final SpringCtxUtil instance = new SpringCtxUtil();
    private static ApplicationContext applicationContext;

    private SpringCtxUtil() {
    }

    public static SpringCtxUtil getInstance() {
        return instance;
    }

    public void setApplicationContext(ApplicationContext applicationContext) {
        if (SpringCtxUtil.applicationContext == null) {
            SpringCtxUtil.applicationContext = applicationContext;
        }
    }

    private static ApplicationContext getApplicationContext() {
        if (applicationContext == null) {
            throw new RuntimeException("请自行设置applicationContext或扫描使用SpringCtxUtilConfig配置后，才可正常使用");
        }
        return applicationContext;
    }

    /**
     * 通过name获取 Bean.
     *
     * @param name
     * @return
     */
    public static Object getBean(String name) {
        return getApplicationContext().getBean(name);
    }

    /**
     * 通过class获取Bean.
     *
     * @param clazz
     * @return
     */
    public static <T> T getBean(Class<T> clazz) {
        return getApplicationContext().getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     *
     * @param name
     * @param clazz
     * @return
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return getApplicationContext().getBean(name, clazz);
    }

    /**
     * 根据key获取配置值.
     *
     * @param key the key
     * @return the property
     */
    public static String getProperty(String key) {
        String property = getApplicationContext().getEnvironment().getProperty(key);
        return property == null ? "" : property;
    }


    /**
     * 获取spring.profiles.active
     *
     * @return
     */
    public static String getActiveProfile() {
        String[] activeProfiles = getApplicationContext().getEnvironment().getActiveProfiles();
        return StringUtils.join(activeProfiles, SignConst.COMMA);
    }

    /**
     * 判断是否开发环境
     *
     * @return
     */
    public static boolean isDev() {
        String activeProfile = getActiveProfile();
        return activeProfile.indexOf("dev") > -1;
    }

    /**
     * 判断是否测试环境
     *
     * @return
     */
    public static boolean isSit() {
        String activeProfile = getActiveProfile();
        return activeProfile.indexOf("sit") > -1;
    }

    /**
     * 判断是否生产环境
     *
     * @return
     */
    public static boolean isProd() {
        String activeProfile = getActiveProfile();
        return activeProfile.indexOf("prod") > -1;
    }

    private static String serviceInfo;

    public static String getServiceInfo() {
        if (serviceInfo == null) {
            // [app:port]-
            serviceInfo = new StringBuilder("[")
                    .append(getApplicationContext().getEnvironment().getProperty("spring.application.name")).append(":")
                    .append(getApplicationContext().getEnvironment().getProperty("server.port")).append("]-").toString();
        }
        return serviceInfo;
    }

    /**
     * 获取调试用户工号
     *
     * @return
     */
    public static String getDebuggerKey() {
        String debuggerKey = getApplicationContext().getEnvironment().getProperty("debuggerKey");
        return StringUtils.isNotBlank(debuggerKey) ? debuggerKey : null;
    }


}
