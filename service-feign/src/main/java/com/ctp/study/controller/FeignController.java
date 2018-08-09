package com.ctp.study.controller;

import com.ctp.study.service.FeignService;
import com.ctp.study.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengtianping
 * @description
 * @date 2017/9/7
 */
@RestController
public class FeignController{

    @Autowired
    private FeignService feignService;

    @RequestMapping("/user/get")
    public Result<String> get(@RequestParam String name){
        Result<String> result = new Result<>();
        Result str = feignService.get(name);
        result.setData("feign ==== " + (String)str.getData());
        return result;
    }
}
