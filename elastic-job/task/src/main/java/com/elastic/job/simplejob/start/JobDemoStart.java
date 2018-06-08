package com.elastic.job.simplejob.start;

import com.dangdang.ddframe.job.event.JobEventConfiguration;
import com.dangdang.ddframe.job.event.rdb.JobEventRdbConfiguration;
import com.dangdang.ddframe.job.lite.api.JobScheduler;
import com.dangdang.ddframe.job.reg.base.CoordinatorRegistryCenter;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperConfiguration;
import com.dangdang.ddframe.job.reg.zookeeper.ZookeeperRegistryCenter;
import com.elastic.job.simplejob.config.EsjobConfig;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

/**
 * 功能说明：TODO
 *
 * @auther by zhaoxl
 * @return <br/>
 * 修改历史：<br/>
 * 1.[2018年04月27日上午11:56]
 */
public class JobDemoStart {
    public static void main(String[] args) {
        new JobScheduler(createRegistryCenter(), EsjobConfig.createJobConfiguration(),jobEventConfiguration()).init();
    }

    private static CoordinatorRegistryCenter createRegistryCenter() {
        ZookeeperRegistryCenter registryCenter = new ZookeeperRegistryCenter(new ZookeeperConfiguration("116.62.11.181:2181", "elastic-job-demo"));
        registryCenter.init();
        return registryCenter;
    }

    private static JobEventConfiguration jobEventConfiguration() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://121.41.110.33:3306/ELASTIC_JOB");
        dataSource.setUser("developer");
        dataSource.setPassword("Dev#timevale123 ");

        JobEventConfiguration jobEventConfiguration = new JobEventRdbConfiguration(dataSource);
        return jobEventConfiguration;
    }
}
