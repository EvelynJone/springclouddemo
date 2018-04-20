package com.springclodedemo.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月16日上午13:14]
 */
@Service
public class ComputeService {
    @Autowired
    RestTemplate template;

    @HystrixCommand(fallbackMethod = "addServiceFallback")
    public String addService() {
        return template.getForEntity("http://COMPUTE-SERVICE/add?a=10&b=20",String.class).getBody();
    }

    public String addServiceFallback() {
        return "error";
    }
}
