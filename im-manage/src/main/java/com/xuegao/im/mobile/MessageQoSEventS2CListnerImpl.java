// package com.xuegao.im.mobile;
//
// import net.x52im.mobileimsdk.server.event.MessageQoSEventListenerS2C;
// import net.x52im.mobileimsdk.server.protocal.Protocal;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// import java.util.ArrayList;
//
// /**
//  * <br/> @PackageName：com.xuegao.im.mobile
//  * <br/> @ClassName：MessageQoSEventListenerS2C
//  * <br/> @Description：
//  * <br/> @author：xuegao
//  * <br/> @date：2021/01/25 16:49
//  */
// public class MessageQoSEventS2CListnerImpl implements MessageQoSEventListenerS2C {
//     private static Logger logger = LoggerFactory.getLogger(MessageQoSEventS2CListnerImpl.class);
//
//     public MessageQoSEventS2CListnerImpl() {
//     }
//
//     @Override
//     public void messagesLost(ArrayList<Protocal> lostMessages) {
//         String s = "【DEBUG_QoS_S2C事件】收到系统的未实时送达事件通知，当前共有" + lostMessages.size() + "个包QoS保证机制结束，判定为【无法实时送达】！";
//         logger.debug(s);
//     }
//
//     @Override
//     public void messagesBeReceived(String theFingerPrint) {
//         if (theFingerPrint != null) {
//             String s = "【DEBUG_QoS_S2C事件】收到对方已收到消息事件的通知，fp=" + theFingerPrint;
//             logger.debug(s);
//         }
//     }
// }