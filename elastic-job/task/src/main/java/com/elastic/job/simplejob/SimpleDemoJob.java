package com.elastic.job.simplejob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月27日上午11:47]
 */
public class SimpleDemoJob implements SimpleJob {
    @Override
    public void execute(ShardingContext context) {
        switch (context.getShardingItem()) {
            case 0:
                System.out.println("job 0");
                break;
            case 1:
                System.out.println("job 1");
                break;
            case 2:
                System.out.println("job 2");
                break;
            case 3:
                System.out.println("job 3");
                break;
            case 4:
                System.out.println("job 4");
                break;
            case 5:
                System.out.println("job 5");
                break;
            case 6:
                System.out.println("job 6");
                break;
        }
    }
}
