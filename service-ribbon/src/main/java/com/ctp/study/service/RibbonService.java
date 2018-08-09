package com.ctp.study.service;

import com.ctp.study.vo.Result;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author chengtianping
 * @description
 * @date 2017/9/7
 */
@Service
public class RibbonService {

    @Autowired
    private RestTemplate restTemplate;

    /**
     * @HystrixCommand注解。该注解对该方法创建了熔断器的功能，并指定了fallbackMethod熔断方法
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hiError")
    public String get(String name){
        //调用下面的方法时采用 方法抛出异常 达到链路断开的效果
        // 必须采用?这种get请求方式
        // 服务提供者name + 方法路径 以及相关参数
        Result result = restTemplate.getForObject("http://service-client/client/user/get?name="+ name, Result.class);
        return (String)result.getData();
    }

    /**
     * 断开链路的时候执行的方法
     * @param name
     * @return
     */
    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
