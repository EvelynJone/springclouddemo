package com.springclouddemo.web;

import com.springclouddemo.client.ComputeClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月12日上午18:16]
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeClient computeClient;


    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public Integer add() {
        return computeClient.add(10,20);
    }

}
