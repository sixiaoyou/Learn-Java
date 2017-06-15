package pers.you.java.multithreading;

public class ThreadDemo01 {

    public static void main(String[] args) {
        // MyThread t1 = new MyThread("A");
        // MyThread t2 = new MyThread("B");

        //// t1.run();
        //// t2.run();
        //// 线程的启动时通过start方法start()
        // t1.start();
        // t2.start();

        MyRunnable r1 = new MyRunnable("A");
        MyRunnable r2 = new MyRunnable("B");

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();

    }
}
