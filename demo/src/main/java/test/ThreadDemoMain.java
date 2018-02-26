package test;

import sun.misc.Unsafe;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/2/2 0002.
 */
public class ThreadDemoMain {

    public void m() {
        Unsafe unsafe = Unsafe.getUnsafe();
        boolean b = unsafe.compareAndSwapInt(this, 1, 2, 3);

        if (1==1) {
            System.out.print(b);
            return;
        }
    }


    public static void main(String[] args) {

        ThreadMethod threadMethod1 = new ThreadMethod();

        new Thread(new ThreadDemo1(threadMethod1)).start();

        Runnable thread = new ThreadDemo2(threadMethod1);
        Thread t = new Thread(thread);
        t.start();
    }
}
