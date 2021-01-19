package com.xuegao.im.controller;

import com.xuegao.im.common.BaseController;
import com.xuegao.im.common.WrappedResponse;
import com.xuegao.im.domain.PageQuery;
import com.xuegao.im.domain.doo.SysGroup;
import com.xuegao.im.domain.doo.SysUser;
import com.xuegao.im.service.interfaces.IIndexService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * <br/> @PackageName：com.xuegao.im.controller
 * <br/> @ClassName：IndexController
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2021/01/17 20:01
 */
@RestController
public class IndexController<T> extends BaseController<T> {
    private final Logger log = LoggerFactory.getLogger(IndexController.class);
    private final IIndexService indexService;

    @Autowired
    public IndexController(IIndexService indexService) {
        this.indexService = indexService;
    }

    @RequestMapping(path = {"", "/", "index"})
    public SysUser list() {
        return indexService.list();
    }

    @ResponseBody
    @RequestMapping(path = "/get1", method = RequestMethod.GET)
    public WrappedResponse<String> get1Test() {
        return WrappedResponse.success("get1");
    }

    @ResponseBody
    @RequestMapping(path = "/get2", method = RequestMethod.GET)
    public WrappedResponse<String> get2Test(@RequestParam String get2) {
        return WrappedResponse.success("get2 = " + get2);
    }

    @ResponseBody
    @RequestMapping(path = "/get3", method = RequestMethod.GET)
    public WrappedResponse<String> get3Test(SysUser sysUser) {
        System.out.println("get3Test = " + sysUser);
        return WrappedResponse.success("get3Test = " + sysUser);
    }

    @ResponseBody
    @RequestMapping(path = "/post1", method = RequestMethod.POST)
    public WrappedResponse<String> post1Test(@RequestBody SysUser sysUserinfo) {
        return WrappedResponse.success("post1 = " + sysUserinfo);
    }

    @ResponseBody
    @RequestMapping(path = "/post2", method = RequestMethod.POST)
    public WrappedResponse<String> post2Test(SysUser sysUserinfo) {
        log.info("SysUserinfo = " + sysUserinfo);
        return WrappedResponse.success("post2 = " + sysUserinfo);
    }

    @ResponseBody
    @RequestMapping(path = "/post3", method = RequestMethod.POST)
    public WrappedResponse<String> post3Test(@RequestParam String post3) {
        return WrappedResponse.success("post3 = " + post3);
    }

    // 前端无法做到这么传参数
    @ResponseBody
    @RequestMapping(path = "/post4", method = RequestMethod.POST)
    public WrappedResponse<String> post4Test(@RequestBody SysUser sysUserinfo, @RequestBody SysGroup product) {
        log.info("post4 = " + sysUserinfo.toString());
        log.info("post4 = " + product.toString());
        return WrappedResponse.success("post4 = " + product);
    }

    // 前端无法做到这么传参数
    @ResponseBody
    @RequestMapping(path = "/post4_v2", method = RequestMethod.POST)
    public WrappedResponse<String> post4Test(@RequestBody PageQuery<SysUser> sysUserinfoPageQuery) {
        log.info("post4_v2 = " + sysUserinfoPageQuery.getPageNum());
        log.info("post4_v2 = " + sysUserinfoPageQuery.getPageSize());
        log.info("post4_v2 = " + sysUserinfoPageQuery.getQueryData());
        return WrappedResponse.success("post4_v2 = " + sysUserinfoPageQuery.getQueryData());
    }

    @ResponseBody
    @RequestMapping(path = "/post5", method = RequestMethod.POST)
    public WrappedResponse<String> post5Test(@RequestBody SysUser sysUserinfo, @RequestParam String post5) {
        log.info("post5 = " + sysUserinfo.toString());
        log.info("post5 = " + post5);
        return WrappedResponse.success("post5 = " + post5);
    }

    @ResponseBody
    @RequestMapping(path = "/file1", method = RequestMethod.POST)
    public WrappedResponse<String> file1(@RequestParam(name = "file", required = false) MultipartFile[] fileArr) {
        System.out.println("===============================");
        for (MultipartFile multipartFile : fileArr) {
            log.info("file1 = " + multipartFile.getName());
            log.info("file1 = " + multipartFile.getOriginalFilename());
        }
        return WrappedResponse.success(Integer.toString(fileArr.length));
    }
}