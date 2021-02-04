package com.xuegao.im.config;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.listener.DataListener;

/**
 * <br/> @PackageName：com.xuegao.im.config
 * <br/> @ClassName：FriendMessageListeners
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/04 18:39
 */
public class FriendMessageListeners implements DataListener<FriendMessage> {
    @Override
    public void onData(SocketIOClient client, FriendMessage data, AckRequest ackSender) throws Exception {
        System.out.println(data);
        client.sendEvent("message", data);
    }
}