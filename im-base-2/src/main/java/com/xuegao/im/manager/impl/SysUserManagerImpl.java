package com.xuegao.im.manager.impl;

import com.xuegao.im.domain.doo.SysUser;
import com.xuegao.im.manager.interfaces.ISysUserManager;
import com.xuegao.im.mapper.ISysUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br/> @PackageName：com.xuegao.im.manager.impl
 * <br/> @ClassName：SysUserManagerImpl
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/31 17:03
 */
@Service
public class SysUserManagerImpl implements ISysUserManager {
    private static final Logger log = LoggerFactory.getLogger(SysUserManagerImpl.class);

    private final ISysUserMapper sysUserMapper;

    @Autowired
    public SysUserManagerImpl(ISysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public Long insert(SysUser sysUser) {
        log.debug("sysUser {}", sysUser);
        sysUserMapper.insert(sysUser);
        return sysUser.getId();
    }
}