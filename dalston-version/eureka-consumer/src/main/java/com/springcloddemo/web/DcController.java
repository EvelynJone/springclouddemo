package com.springcloddemo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月11日上午10:12]
 */
@RestController
public class DcController {

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/consumer")
    public String dc() {
        // 先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，这个服务实例的基本信息存储在ServiceInstance中
        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");

        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        System.out.println(url);

        // 利用RestTemplate对象实现对服务提供者接口的调用
        return restTemplate.getForObject(url,String.class);
    }

}
