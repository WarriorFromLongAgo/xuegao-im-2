package com.xuegao.im.manager.impl;

import com.xuegao.im.domain.doo.FriendMessage;
import com.xuegao.im.manager.interfaces.IFriendMessageManager;
import com.xuegao.im.mapper.IFriendMessageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br/> @PackageName：com.xuegao.im.manager.impl
 * <br/> @ClassName：FriendMessageManagerImpl
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/02/04 16:22
 */
@Service
public class FriendMessageManagerImpl implements IFriendMessageManager {

    private final IFriendMessageMapper friendMessageMapper;

    @Autowired
    public FriendMessageManagerImpl(IFriendMessageMapper friendMessageMapper) {
        this.friendMessageMapper = friendMessageMapper;
    }

    @Override
    public Long insert(FriendMessage friendMessage) {
        friendMessageMapper.insert(friendMessage);
        return friendMessage.getId();
    }



}