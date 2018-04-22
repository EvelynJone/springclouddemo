package com.consul.lock.test;

import com.consul.lock.Lock;
import com.ecwid.consul.v1.ConsulClient;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Random;

/**
 * @auther zhaoxl
 * @date 2018/4/22.
 */
public class LockTest {

    private static final Logger logger = LoggerFactory.getLogger(LockTest.class);

    @Test
    public void testLock() throws InterruptedException {
        new Thread(new LockRunner(1)).start();
        new Thread(new LockRunner(2)).start();
        new Thread(new LockRunner(3)).start();
        new Thread(new LockRunner(4)).start();
        new Thread(new LockRunner(5)).start();
        Thread.sleep(200000L);
    }

    class LockRunner implements Runnable {
        private final Logger logger = LoggerFactory.getLogger(LockRunner.class);

        private int flag;

        public LockRunner(int flag) {
            this.flag = flag;
        }

        @Override
        public void run() {
            Lock lock = new Lock(new ConsulClient(),"lock-session","lock-key");
            try {
                if (lock.lock(true)) {
                    logger.info("Thread " + flag + " start!");
                    Thread.sleep(new Random().nextInt(3000));
                    logger.info("Thread " + flag + " end!");
                }
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}
