package com.es.job.springboot.job;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年05月02日上午14:21]
 */
@Component
public class SpringSimpleJob implements SimpleJob{

    @Override
    public void execute(ShardingContext context) {
        System.out.println("job "+context.getShardingItem());
    }
}
