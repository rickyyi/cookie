package test;

/**
 * Created by Administrator on 2018/2/23 0023.
 */
public class ThreadDemo2 implements Runnable {

    private ThreadMethod threadMethod;

    public ThreadDemo2(ThreadMethod threadMethod) {
        this.threadMethod = threadMethod;
    }

    @Override
    public void run() {
        threadMethod.method2();
    }
}
