package test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
public class ThreadDemo1 implements Runnable {

    private ThreadMethod threadMethod;

    public ThreadDemo1(ThreadMethod threadMethod) {
        this.threadMethod = threadMethod;
    }

    @Override
    public void run() {
        threadMethod.method1();
    }
}
