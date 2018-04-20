package com.springclouddemo.test;

import com.springclouddemo.client.ComputeClient;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月12日上午19:00]
 */
@SpringBootTest
public class FeignTest {

    @Autowired
    ComputeClient computeClient;

    @Test
    public void add() {
        System.out.println(computeClient.add(10, 20));
    }

}
