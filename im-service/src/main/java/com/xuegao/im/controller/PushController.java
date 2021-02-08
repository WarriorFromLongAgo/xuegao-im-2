package com.xuegao.im.controller;

import com.corundumstudio.socketio.SocketIOClient;
import com.xuegao.im.config.SocketIoHandler;
import com.xuegao.im.domain.doo.FriendMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.BiConsumer;

/**
 * <br/> @PackageName：com.xuegao.im.controller
 * <br/> @ClassName：PushController
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/05 15:34
 */
@RestController
@RequestMapping(path = "/push")
public class PushController {

    @PostMapping(path = "/send")
    public void send(String sessionId) {
        SocketIOClient socketIOClient = SocketIoHandler.clientMap.get(sessionId);
        FriendMessage friendMessage = new FriendMessage();
        friendMessage.setFromUserId(0L);
        friendMessage.setTargetUserId(0L);
        friendMessage.setMsgType("text");
        friendMessage.setMsgBody("这是一条系统消息");
        socketIOClient.sendEvent("message", friendMessage);
    }

    @PostMapping(path = "/push-all")
    public void pushAll() {
        SocketIoHandler.clientMap.forEach(new BiConsumer<String, SocketIOClient>() {
            @Override
            public void accept(String s, SocketIOClient socketIOClient) {
                FriendMessage friendMessage = new FriendMessage();
                friendMessage.setFromUserId(0L);
                friendMessage.setTargetUserId(0L);
                friendMessage.setMsgType("text");
                friendMessage.setMsgBody("这是一条系统消息");
                socketIOClient.sendEvent("message", friendMessage);
            }
        });
    }
}