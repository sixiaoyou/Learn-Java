package pers.you.java.multithreading;

import org.apache.hadoop.classification.InterfaceAudience.Public;
import org.apache.hadoop.hive.ql.parse.HiveParser_IdentifiersParser.identifier_return;
import org.junit.Test;

class RunnableDemo implements Runnable {

    private String name;

    public RunnableDemo(String name) {
        this.name = name;
    }
    // 1. getName
    // public void run() {
    // for (int i = 0; i < 50; i++) {
    //// System.out.println("当前线程对象" + Thread.currentThread().getName());
    // System.out.println(name + ":" + i);
    // }
    //
    // }

    // 2. Sleep
    // public void run(){
    // for(int i = 0;i<50;i++){
    // try{
    // Thread.sleep(1000);
    // System.out.println(name + ":" +i);
    // }catch(InterruptedException e){
    // e.printStackTrace();
    // }
    // }
    // }

    // 3.yield
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(name + ":" + i);
            if (i == 10) {
                System.out.println("礼让");
                Thread.yield();
            }
        }
    }
}

public class ThreadDemo03 {

    public static void main(String[] args) {
        // 1. currenThread & getName
        // RunnableDemo r1 = new RunnableDemo("A");
        // RunnableDemo r2 = new RunnableDemo("A");
        // Thread t1 = new Thread(r1);
        // Thread t2= new Thread(r1);
        // t1.start();
        // t2.start();
        // }

        // 2. isAlive
        // RunnableDemo r = new RunnableDemo("A");
        // Thread t = new Thread(r);
        // System.out.println(t.isAlive());
        // t.start();
        // System.out.println(t.isAlive());

        // 3. join 强行让A线程执行
        // RunnableDemo r = new RunnableDemo("A");
        // Thread t = new Thread(r);
        // t.start();
        // for(int i = 0;i<50;i++){
        // if(i>10){
        // try{
        // t.join();
        // }catch(InterruptedException e){
        // e.printStackTrace();
        // }
        // }
        // System.out.println("主线程: " + i );
        // }

        // 4. sleep
        // RunnableDemo r = new RunnableDemo("A");
        // Thread t = new Thread(r);
        // t.start();

        // 5. yield
        RunnableDemo r1 = new RunnableDemo("A");
        RunnableDemo r2 = new RunnableDemo("B");
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        t1.start();
        t2.start();
    }
}
