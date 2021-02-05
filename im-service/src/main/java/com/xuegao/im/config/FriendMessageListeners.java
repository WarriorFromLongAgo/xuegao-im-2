package com.xuegao.im.config;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.xuegao.im.domain.doo.FriendMessage;

/**
 * <br/> @PackageName：com.xuegao.im.config
 * <br/> @ClassName：FriendMessageListeners
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/04 18:39
 */
public class FriendMessageListeners implements DataListener<FriendMessage> {

    private SocketIOServer server;

    public void setServer(SocketIOServer server) {
        this.server = server;
    }

    @Override
    public void onData(SocketIOClient client, FriendMessage data, AckRequest ackSender) throws Exception {
        System.out.println(data);
        client.sendEvent("message", data);
        //服务端接受客户端的消息后，回应客户端， chatevent为 事件的名称， msg为发送的内容
        this.server.getBroadcastOperations().sendEvent("message", data);
    }
}