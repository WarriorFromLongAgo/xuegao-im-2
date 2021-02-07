package com.xuegao.im.config;

import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * <br/> @PackageName：com.xuegao.im.config
 * <br/> @ClassName：NettySocketioConfig
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/02 19:55
 */
@Configuration
public class NettySocketIoConfig implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(NettySocketIoConfig.class);

    @Value("${socketio.host}")
    private String host;
    @Value("${socketio.port}")
    private Integer port;

    // netty-socketio服务器
    @Bean
    public SocketIOServer socketIoServer() {
        com.corundumstudio.socketio.Configuration config = new com.corundumstudio.socketio.Configuration();
        config.setHostname(host);
        config.setPort(port);

        // 该处可以用来进行身份验证
        // config.setAuthorizationListener(new AuthorizationListener() {
        //     @Override
        //     public boolean isAuthorized(HandshakeData data) {
        //         // http://localhost:8081?username=test&password=test
        //         // 例如果使用上面的链接进行connect，可以使用如下代码获取用户密码信息，本文不做身份验证
        //         // String username = data.getSingleUrlParam("username");
        //         // String password = data.getSingleUrlParam("password");
        //         return true;
        //     }
        // });

        return new SocketIOServer(config);
    }

    //用于扫描netty-socketio的注解，比如 @OnConnect、@OnEvent
    @Bean
    public SpringAnnotationScanner springAnnotationScanner() {
        return new SpringAnnotationScanner(socketIoServer());
    }

    @Override
    public void afterPropertiesSet() {
        log.info(" start socket ");
        socketIoServer().start();
    }
}