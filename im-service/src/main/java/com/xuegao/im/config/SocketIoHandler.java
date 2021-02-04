package com.xuegao.im.config;

import com.alibaba.fastjson.JSON;
import com.corundumstudio.socketio.AckRequest;
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

    // private final IFriendMessageManager friendMessageManager;
    //
    // @Autowired
    // public SocketIoHandler(IFriendMessageManager friendMessageManager) {
    //     this.friendMessageManager = friendMessageManager;
    // }

    //客户端连上socket服务器时执行此事件
    @OnConnect
    public void onConnect(SocketIOClient client) {
        log.info(" onConnect ");
        String json = JSON.toJSONString(client);


        //     {
        //         "allRooms": [
        //         ""
        // ],
        //         "baseClient": {
        //         "ackManager": {},
        //         "channelOpen": false,
        //                 "connected": true,
        //                 "currentTransport": "POLLING",
        //                 "handshakeData": {
        //             "address": {
        //                 "address": "127.0.0.1",
        //                         "port": 4954
        //             },
        //             "httpHeaders": {
        //                 "empty": false
        //             },
        //             "local": {
        //                 "address": "127.0.0.1",
        //                         "port": 9092
        //             },
        //             "time": 1612354410184,
        //                     "url": "/socket.io/?EIO=3&transport=polling&t=1612354409724-0",
        //                     "urlParams": {
        //                 "EIO": [
        //                 "3"
        //             ],
        //                 "transport": [
        //                 "polling"
        //             ],
        //                 "t": [
        //                 "1612354409724-0"
        //             ]
        //             },
        //             "xdomain": true
        //         },
        //         "namespaces": [
        //         {
        //             "allClients": [
        //             {
        //                 "$ref": "$"
        //             }
        //             ],
        //             "broadcastOperations": {
        //             "clients": [
        //             {
        //                 "$ref": "$"
        //             }
        //                 ]
        //         },
        //             "jsonSupport": {
        //             "arrays": []
        //         },
        //             "name": "",
        //                 "rooms": [
        //             ""
        //             ]
        //         }
        //     ],
        //         "origin": "http://localhost:13000",
        //                 "remoteAddress": {
        //             "address": "127.0.0.1",
        //                     "port": 4954
        //         },
        //         "sessionId": "3ec17066-8432-4c28-9c81-30056206cee4",
        //                 "store": {}
        //     },
        //         "channelOpen": false,
        //             "handshakeData": {
        //         "$ref": "$.baseClient.handshakeData"
        //     },
        //         "namespace": {
        //         "$ref": "$.baseClient.namespaces[0]"
        //     },
        //         "remoteAddress": {
        //         "address": "127.0.0.1",
        //                 "port": 4954
        //     },
        //         "sessionId": "3ec17066-8432-4c28-9c81-30056206cee4",
        //             "transport": "POLLING"
        //     }


        log.info(json);
        String userId = client.getHandshakeData().getSingleUrlParam("sessionId");
        if (userId != null) {
            clientMap.put(userId, client);
        }
    }

    //客户端断开socket服务器时执行此事件
    @OnDisconnect
    public void onDisconnect(SocketIOClient client) {
        log.info(" onDisconnect ");
        String json = JSON.toJSONString(client);

        // {
        //     "allRooms": [],
        //     "baseClient": {
        //     "ackManager": {},
        //     "channelOpen": true,
        //             "connected": true,
        //             "currentTransport": "WEBSOCKET",
        //             "handshakeData": {
        //         "address": {
        //             "address": "127.0.0.1",
        //                     "port": 4954
        //         },
        //         "httpHeaders": {
        //             "empty": false
        //         },
        //         "local": {
        //             "address": "127.0.0.1",
        //                     "port": 9092
        //         },
        //         "time": 1612354410184,
        //                 "url": "/socket.io/?EIO=3&transport=polling&t=1612354409724-0",
        //                 "urlParams": {
        //             "EIO": [
        //             "3"
        //         ],
        //             "transport": [
        //             "polling"
        //         ],
        //             "t": [
        //             "1612354409724-0"
        //         ]
        //         },
        //         "xdomain": true
        //     },
        //     "namespaces": [],
        //     "origin": "http://localhost:13000",
        //             "remoteAddress": {
        //         "address": "127.0.0.1",
        //                 "port": 4954
        //     },
        //     "sessionId": "3ec17066-8432-4c28-9c81-30056206cee4",
        //             "store": {}
        // },
        //     "channelOpen": true,
        //         "handshakeData": {
        //     "$ref": "$.baseClient.handshakeData"
        // },
        //     "namespace": {
        //     "allClients": [],
        //     "broadcastOperations": {
        //         "clients": []
        //     },
        //     "jsonSupport": {
        //         "arrays": []
        //     },
        //     "name": "",
        //             "rooms": []
        // },
        //     "remoteAddress": {
        //     "address": "127.0.0.1",
        //             "port": 4954
        // },
        //     "sessionId": "3ec17066-8432-4c28-9c81-30056206cee4",
        //         "transport": "WEBSOCKET"
        // }

        log.info(json);
        String userId = client.getHandshakeData().getSingleUrlParam("sessionId");
        if (userId != null) {
            clientMap.remove(userId);
            client.disconnect();
        }
    }

    //服务器向客户端发送事件
    @OnEvent(value = "group")
    public void group(SocketIOClient client, FriendMessage data, final AckRequest ackRequest) {
        log.info(" group ");
        log.info(data.toString());
    }

    @OnEvent(value = "friend")
    public void ackevent1(SocketIOClient client, FriendMessage data, final AckRequest ackRequest) {
        log.info(" ackevent1 ");
        log.info(data.toString());
        // check is ack requested by client,
        // but it's not required check
        if (ackRequest.isAckRequested()) {
            // friendMessageManager.insert(data);
            // send ack response with data to client
            ackRequest.sendAckData("client message was delivered to server!", "yeah!");
        }

        // // send message back to client with ack callback WITH data
        // // FriendMessage ackChatObjectData = new FriendMessage(data.getFromuserid(), "message with ack data");
        // client.sendEvent("ackevent2", new AckCallback<String>(String.class) {
        //     @Override
        //     public void onSuccess(String result) {
        //         System.out.println("ack from client: " + client.getSessionId() + " data: " + result);
        //     }
        // }, data);
        //
        // // ChatObject ackChatObjectData1 = new ChatObject(data.getUserName(), "message with void ack");
        // client.sendEvent("ackevent3", new AckCallback<String>(String.class) {
        //     @Override
        //     public void onSuccess(String result) {
        //         System.out.println("void ackevent3 ack from: " + client.getSessionId());
        //     }
        // }, data);
        // // client.sendEvent("ackevent3", new VoidAckCallback() {
        // //     @Override
        // //     protected void onSuccess() {
        // //         System.out.println("void ack from: " + client.getSessionId());
        // //     }
        // // });
        //
        // client.sendEvent("message", data);
    }

}