package com.ctp.study.controller;

import com.ctp.study.vo.Result;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengtianping
 * @description 服务提供者 以接口的方式提供 给服务调用者使用 微服务
 * @date 2017/9/7
 */
@RestController
public class UserController {

    @Value("${server.port}")
    private String port;

   @RequestMapping("/client/user/get")
   public Result<String> get(@RequestParam String name){
       Result<String> result = new Result<>();
       // 演示 链路器的作用
       //int i = 1/0;
       result.setData("hello world == " + name + " === " + port);
       return result;
   }
}
