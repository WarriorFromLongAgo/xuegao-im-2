package com.xuegao.immanage.controller;

import com.xuegao.imcommon.constant.common.WrappedResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <br/> @PackageName：com.xuegao.immanage
 * <br/> @ClassName：IndexController
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/1/10 23:39
 */
@RestController
public class IndexController {
    private final Logger log = LoggerFactory.getLogger(IndexController.class);

    @GetMapping(path = {"/", "/index"})
    public WrappedResponse<String> uploadFile() {
        log.info("index 访问成功");
        return WrappedResponse.success("index");
    }
}