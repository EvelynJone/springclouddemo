package com.es.job.springboot.job;// package com.timevale.LawIssue.biz.task;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import org.springframework.stereotype.Component;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年06月04日上午13:34]
 */

@Component(value = "eviSimpleJob")
public class EviSimpleJob implements SimpleJob {

    @Override
    public void execute(ShardingContext context) {
        System.out.println("分片： " + context.getShardingItem());

    }
}