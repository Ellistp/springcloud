//package com.ctp.study.config;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
///**
// * @author chengtianping
// * @description
// * @date 2017/9/4
// */
///*
//* 创建一个Spring配置，用于创建一个支持Spring Session的Servlet Filter
//* 来代替原有的HttpSession的实现
//* 这个类用配置redis服务器的连接
//* */
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds=60)
//public class RedisSessionConfig {
//
//    @Value("${spring.redis.host}")
//    private String host;
//
//    @Value("${spring.redis.port}")
//    private int port;
//
//    /*
//    * 参考JedisConnectionFactory 中的参数 ，可以修改地址和端口号
//    * */
//    @Bean
//    public JedisConnectionFactory connectionFactory() {
//        JedisConnectionFactory connection = new JedisConnectionFactory();
//        connection.setHostName(host);
//        connection.setPort(port);
//        return connection;
//    }
//
//}
