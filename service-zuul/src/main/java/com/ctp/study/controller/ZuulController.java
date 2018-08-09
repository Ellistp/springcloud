package com.ctp.study.controller;

import javax.servlet.http.HttpServletRequest;

import com.ctp.study.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengtianping
 * @description 路由 控制器
 * @date 2017/9/8
 */
@RestController
public class ZuulController {

    @RequestMapping("/api/a/get")
    public Result get(HttpServletRequest request){
        Result result = new Result();
        return result;
    }
}
