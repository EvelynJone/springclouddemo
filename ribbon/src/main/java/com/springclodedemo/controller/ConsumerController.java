package com.springclodedemo.controller;

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
 * 1.[2018年04月12日上午13:34]
 */
@RestController
public class ConsumerController {

    @Autowired
    ComputeService service;

    @RequestMapping(value = "/add",method = RequestMethod.GET)
    public String add() {
        return service.addService();
    }

}
