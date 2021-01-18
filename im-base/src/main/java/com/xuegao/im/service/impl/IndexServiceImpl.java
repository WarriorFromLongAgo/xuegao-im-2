package com.xuegao.im.service.impl;

import com.alibaba.fastjson.JSON;
import com.xuegao.im.domain.doo.SysUser;
import com.xuegao.im.mapper.ISysUserMapper;
import com.xuegao.im.service.interfaces.IIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <br/> @PackageName：com.sf.edu.service.impl.train
 * <br/> @ClassName：IndexServiceImpl
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/17 17:23
 */
@Service
public class IndexServiceImpl implements IIndexService {
    private static final Logger log = LoggerFactory.getLogger(IndexServiceImpl.class);

    private final ISysUserMapper sysUserMapper;

    @Autowired
    public IndexServiceImpl(ISysUserMapper sysUserMapper) {
        this.sysUserMapper = sysUserMapper;
    }

    @Override
    public SysUser list() {
        SysUser sysUser = new SysUser();
        sysUser.setUsername("1");
        sysUser.setUsercode("1");
        sysUser.setPassword("1");
        sysUser.setNickname("1");
        sysUser.setHeadimage("1");
        sysUser.setStatus(1);
        sysUser.setDeleteflag(1);
        sysUser.setUpdateid(1L);
        sysUser.setCreateid(1L);
        sysUserMapper.insert(sysUser);
        String s = JSON.toJSONString(sysUser);
        log.info(s);
        return sysUser;
    }
}