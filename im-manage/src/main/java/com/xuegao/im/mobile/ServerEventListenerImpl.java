// package com.xuegao.im.mobile;
//
// import io.netty.channel.Channel;
// import net.x52im.mobileimsdk.server.event.ServerEventListener;
// import net.x52im.mobileimsdk.server.protocal.Protocal;
// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
//
// /**
//  * <br/> @PackageName：com.xuegao.im.mobile
//  * <br/> @ClassName：ServerEventListenerImpl
//  * <br/> @Description：
//  * <br/> @author：xuegao
//  * <br/> @date：2021/01/25 16:53
//  */
// public class ServerEventListenerImpl implements ServerEventListener {
//     private static Logger logger = LoggerFactory.getLogger(ServerEventListenerImpl.class);
//
//     public ServerEventListenerImpl() {
//     }
//
//     @Override
//     public int onUserLoginVerify(String userId, String token, String extra, Channel session) {
//         logger.debug("【DEBUG_回调通知】正在调用回调方法：OnVerifyUserCallBack...(extra=" + extra + ")");
//         return 0;
//     }
//
//     @Override
//     public void onUserLoginSucess(String userId, String extra, Channel session) {
//         logger.debug("【IM_回调通知OnUserLoginAction_CallBack】用户：" + userId + " 上线了！");
//     }
//
//     @Override
//     public void onUserLogout(String userId, Object obj, Channel session) {
//         logger.debug("【DEBUG_回调通知OnUserLogoutAction_CallBack】用户：" + userId + " 离线了！");
//     }
//
//     @Override
//     public boolean onTransferMessage4C2S(Protocal p, Channel session) {
//         String userId = p.getTo();
//         String from_user_id = p.getFrom();
//         String dataContent = p.getDataContent();
//         String fingerPrint = p.getFp();
//         int typeu = p.getTypeu();
//         logger.debug("【DEBUG_回调通知】[typeu=" + typeu + "]收到了客户端" + from_user_id + "发给服务端的消息：str=" + dataContent);
//         return true;
//     }
//
//     @Override
//     public void onTransferMessage4C2C(Protocal p) {
//         String userId = p.getTo();
//         String from_user_id = p.getFrom();
//         String dataContent = p.getDataContent();
//         String fingerPrint = p.getFp();
//         int typeu = p.getTypeu();
//         logger.debug("【DEBUG_回调通知】[typeu=" + typeu + "]收到了客户端" + from_user_id + "发给客户端" + userId + "的消息：str=" + dataContent);
//     }
//
//     @Override
//     public boolean onTransferMessage_RealTimeSendFaild(Protocal p) {
//         String userId = p.getTo();
//         String from_user_id = p.getFrom();
//         String dataContent = p.getDataContent();
//         String fingerPrint = p.getFp();
//         int typeu = p.getTypeu();
//         logger.debug("【DEBUG_回调通知】[typeu=" + typeu + "]客户端" + from_user_id + "发给客户端" + userId + "的消息：str=" + dataContent + "，因实时发送没有成功，需要上层应用作离线处理哦，否则此消息将被丢弃.");
//         return false;
//     }
// }