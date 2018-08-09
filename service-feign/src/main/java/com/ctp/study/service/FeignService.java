package com.ctp.study.service;

import com.ctp.study.vo.Result;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author chengtianping
 * @description 服务接口
 * @date 2017/9/7
 */
@FeignClient(value = "service-client")
public interface FeignService {

    @RequestMapping("/client/user/get")
    Result<String> get(@RequestParam(value = "name") String name);
}
