package com.xuegao.im.config;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.annotation.OnConnect;
import com.corundumstudio.socketio.annotation.OnDisconnect;
import com.corundumstudio.socketio.annotation.OnEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * <br/> @PackageName：com.xuegao.im.config
 * <br/> @ClassName：LoginHandler
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/02 19:57
 */
@Component
public class SocketIoHandler {
    private static final Logger log = LoggerFactory.getLogger(SocketIoHandler.class);
    private static Map<String, SocketIOClient> clientMap = new ConcurrentHashMap<>();

    //客户端连上socket服务器时执行此事件
    @OnConnect
    public void onConnect(SocketIOClient client) {
        log.info(" onConnect ");
        String json = JSON.toJSONString(client);
        log.info(json);
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            clientMap.put(userId, client);
        }
    }

    //客户端断开socket服务器时执行此事件
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        log.info(" onDisconnect ");
        String json = JSON.toJSONString(client);
        log.info(json);
        String userId = client.getHandshakeData().getSingleUrlParam("userId");
        if (userId != null) {
            clientMap.remove(userId);
            client.disconnect();
        }
    }

    //服务器向客户端发送事件
    @OnEvent(value = "group")
    public void group(String userId) {
        log.info(" group ");
        if (StringUtils.isNotBlank(userId)) {
            SocketIOClient client = clientMap.get(userId);
            if (client != null) {
                client.sendEvent("pushMsg", "hello-Rorschache");
            }
        }
    }

    @OnEvent(value = "client")
    public void client(String userId) {
        log.info(" client ");
        if (StringUtils.isNotBlank(userId)) {
            SocketIOClient client = clientMap.get(userId);
            if (client != null) {
                client.sendEvent("pushMsg", "hello-Rorschache");
            }
        }
    }
}