package test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
public class ThreadMethod {

    private List<Thread> list = new ArrayList();
    private Lock lock = new ReentrantLock();

    public void method1() {
        list.add(Thread.currentThread());
        System.out.println(Thread.currentThread().getName() + " 中断");
        LockSupport.park(this);
        System.out.println(Thread.currentThread().getName() + " enter method 1");
    }

    public void method2() {
        System.out.println(Thread.currentThread().getName() + " enter method 2");
        try {
            Thread.sleep(3000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LockSupport.unpark(list.get(0));
    }
}
