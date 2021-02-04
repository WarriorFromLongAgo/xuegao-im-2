package com.xuegao.im.manager.interfaces;

import com.xuegao.im.domain.doo.FriendMessage;

/**
 * <br/> @PackageName：com.xuegao.im.manager.interfaces
 * <br/> @ClassName：IFriendMessageManager
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/04 16:21
 */
public interface IFriendMessageManager {

    Long insert(FriendMessage friendMessage);
}