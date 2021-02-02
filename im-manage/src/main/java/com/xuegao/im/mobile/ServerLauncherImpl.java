// package com.xuegao.im.mobile;
//
// import net.x52im.mobileimsdk.server.ServerLauncher;
// import net.x52im.mobileimsdk.server.network.GatewayTCP;
// import net.x52im.mobileimsdk.server.network.GatewayUDP;
// import net.x52im.mobileimsdk.server.qos.QoS4ReciveDaemonC2S;
// import net.x52im.mobileimsdk.server.qos.QoS4SendDaemonS2C;
//
// import java.io.IOException;
//
// /**
//  * <br/> @PackageName：com.xuegao.im.mobile
//  * <br/> @ClassName：ServerLauncherImpl
//  * <br/> @Description：
//  * <br/> @author：xuegao
//  * <br/> @date：2021/01/25 16:56
//  */
// public class ServerLauncherImpl extends ServerLauncher {
//     static {
//         GatewayUDP.PORT = 7901;
//         GatewayTCP.PORT = 8901;
//         ServerLauncher.supportedGateways = 3;
//         QoS4SendDaemonS2C.getInstance().setDebugable(true);
//         QoS4ReciveDaemonC2S.getInstance().setDebugable(true);
//         ServerLauncher.debug = true;
//         ServerLauncher.bridgeEnabled = false;
//     }
//
//     public ServerLauncherImpl() throws IOException {
//     }
//
//     @Override
//     protected void initListeners() {
//         this.setServerEventListener(new ServerEventListenerImpl());
//         this.setServerMessageQoSEventListener(new MessageQoSEventS2CListnerImpl());
//     }
//
//     public static void main(String[] args) throws Exception {
//         final ServerLauncherImpl sli = new ServerLauncherImpl();
//         sli.startup();
//         Runtime.getRuntime().addShutdownHook(new Thread() {
//             public void run() {
//                 sli.shutdown();
//             }
//         });
//     }
// }