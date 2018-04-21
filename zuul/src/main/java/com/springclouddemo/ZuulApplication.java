package com.springclouddemo;

import com.springclouddemo.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * @auther zhaoxl
 * @date 2018/4/21.
 */
@EnableZuulProxy // 注解开启Zuul
@SpringCloudApplication // 整合@SpringBootApplication@EnableDiscoveryClient@EnableCircuitBreaker，简化配置
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class,args);
    }

    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }
}
