package com.xuegao.im.controller;

import com.xuegao.im.domain.doo.SysUser;
import com.xuegao.im.service.interfaces.IIndexService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/> @PackageName：com.xuegao.im.controller
 * <br/> @ClassName：IndexController
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/17 20:09
 */
@RestController
public class IndexController {

    private final IIndexService indexService;

    @Autowired
    public IndexController(IIndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(path = {"", "/", "index"})
    public SysUser list() {
        return indexService.list();
    }
}