package com.ctp.study.controller;

import com.ctp.study.service.RibbonService;
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
public class Ribbon2Controller {

    @Autowired
    private RibbonService ribbonService;

    @RequestMapping("/user/get")
    public Result<String> get(@RequestParam String name){
        Result<String> result = new Result<>();
        String str = ribbonService.get(name);
        result.setData("ribbon === " + str);
        return result;
    }
}
