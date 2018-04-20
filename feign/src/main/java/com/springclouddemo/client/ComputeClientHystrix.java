package com.springclouddemo.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月16日上午14:00]
 */
@Component
public class ComputeClientHystrix implements ComputeClient {

    private static final Logger LOG = LoggerFactory.getLogger(ComputeClientHystrix.class);

    @Override
    public Integer add(@RequestParam(value = "a") Integer a, @RequestParam(value = "b") Integer b) {
        LOG.error("input thing : {},{}",a,b);
        return -9999;
    }

}
