package pers.you.java.concurrent;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LDemo {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new MT().start();
        new MT().start();
        new MT().start();
        new MT().start();
    }
}

class Data {
    static int i = 0;
    static Lock lock = new ReentrantLock();
    static AtomicInteger ai = new AtomicInteger(0);
     
    static void operate() {
        System.out.println(ai.incrementAndGet());
//        lock.lock();
//        i++;
//        System.out.println(i);
//        lock.unlock();
    }
}

class MT extends Thread {
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000);
                Data.operate();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }
}
