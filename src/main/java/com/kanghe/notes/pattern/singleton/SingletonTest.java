package com.kanghe.notes.pattern.singleton;

import com.kanghe.notes.pattern.singleton.hungry.Hungry;
import lombok.extern.slf4j.Slf4j;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * 线程安全测试
 */
@Slf4j
public class SingletonTest {

    public static void main(String[] args) {
        int count = 100;
        CountDownLatch latch = new CountDownLatch(count);
        final Set<Hungry> syncSet = Collections.synchronizedSet(new HashSet<>());
        for (int i = 0; i < count; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        latch.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
//                    syncSet.add(Hungry.getInstance());
                    System.out.println(System.currentTimeMillis() + ":" + Hungry.getInstance());
                }
            }.start();
            latch.countDown();
        }
    }

}
