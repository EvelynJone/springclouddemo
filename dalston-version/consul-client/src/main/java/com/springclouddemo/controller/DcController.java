package com.springclouddemo.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月25日上午13:08]
 */
@RestController
public class DcController {

    private static final Logger LOG = LoggerFactory.getLogger(DcController.class);

    @Autowired
    DiscoveryClient discoveryClient;

    @GetMapping("/dc")
    public String dc() {
        String services = "Services: " +  discoveryClient.getServices();
        LOG.info("eureka client : {}",services);
        return services;
    }

}
