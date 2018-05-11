package com.springclouddemo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月12日上午13:13]
 */
@RestController
public class ComputeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a ,@RequestParam Integer b ) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a + b;
        logger.info("/add,host: {} , service_id: {},result:{}",
                instance.getHost(),instance.getServiceId() ,r);
        return r;
    }

    @RequestMapping(value = "/sub",method = RequestMethod.POST)
    public Integer sub(@RequestBody SubParam a) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a.getA() - a.getB();
        logger.info("/sub,host: {} , service_id: {},result:{}",
                instance.getHost(),instance.getServiceId() ,r);
        return r;
    }

    @RequestMapping(value = "/put",method = RequestMethod.PUT)
    public Integer put(@RequestBody SubParam a) {
        ServiceInstance instance = client.getLocalServiceInstance();
        Integer r = a.getA() - a.getB();
        logger.info("/sub,host: {} , service_id: {},result:{}",
                instance.getHost(),instance.getServiceId() ,r);
        return r;
    }
}
