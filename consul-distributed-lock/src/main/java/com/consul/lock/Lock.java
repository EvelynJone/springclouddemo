package com.consul.lock;

import com.ecwid.consul.v1.ConsulClient;
import com.ecwid.consul.v1.kv.model.PutParams;
import com.ecwid.consul.v1.session.model.NewSession;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @auther zhaoxl
 * @date 2018/4/22.
 */
public class Lock {
    private static final String prefix = "lock/"; //同步锁前缀

    private ConsulClient consulClient;
    private String sessionName;
    private String sessionId = null;
    private String lockKey;


    /**
     *
     * @param consulClient
     * @param sessionName 同步锁的session名称
     * @param lockKey      同步锁在consul的KV存储中的key路径，会自动增加prefix前缀，方便归类查询
     */
    public Lock(ConsulClient consulClient, String sessionName, String lockKey) {
        this.consulClient = consulClient;
        this.sessionName = sessionName;
        this.lockKey = lockKey;
    }

    /**
     * 获取同步锁
     * @param block 是否阻塞，直到获取锁为止
     * @return
     */
    public Boolean lock(boolean block) {
        if (sessionId != null) {
            throw new RuntimeException(sessionId + " - Already lock");
        }

        sessionId = createSession(sessionName);
        while (true) {
            PutParams putParams = new PutParams();
            putParams.setAcquireSession(sessionId);
            if (consulClient.setKVValue(lockKey,"lock:" + LocalDateTime.now(),putParams).getValue()){
                return true;
            }else if (block) {
                continue;
            }else {
                return false;
            }
        }
    }

    public Boolean unlock() {
        PutParams putParams = new PutParams();
        putParams.setReleaseSession(sessionId);
        Boolean result = consulClient.setKVValue(lockKey, "unlock:" + LocalDateTime.now(),putParams).getValue();
        consulClient.sessionDestroy(sessionId,null);
        return result;
    }

    private String createSession(String sessionName) {
        NewSession newSession = new NewSession();
        newSession.setName(sessionName);
        return consulClient.sessionCreate(newSession,null).getValue();
    }

}
