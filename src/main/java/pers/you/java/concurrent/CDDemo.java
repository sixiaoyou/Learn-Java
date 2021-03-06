package pers.you.java.concurrent;

import java.util.concurrent.CountDownLatch;

public class CDDemo {
    public static void main(String[] args){
        CountDownLatch countDownLatch = new CountDownLatch(3);
        
        new Racer(countDownLatch, "A").start();
        new Racer(countDownLatch, "B").start();
        new Racer(countDownLatch, "C").start();
        
        for(int i = 3;i>0;i--){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.println(i);
            countDownLatch.countDown();
            if(i == 1){
                System.out.println("Start");
            }
        }
        
    }
    
    
}


class Racer extends Thread{
    
    private CountDownLatch countDownLatch ;
    
    public Racer(CountDownLatch countDownLatch , String name){
        setName(name);
        this.countDownLatch = countDownLatch;
    }
    
    public void run(){
        try {
            countDownLatch.await();
            for(int i = 0;i<3;i++){
                System.out.println(getName() + " : " + i);
            }
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
        
        
    }
    
    
}
