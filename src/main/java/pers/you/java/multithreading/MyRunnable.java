package pers.you.java.multithreading;

public class MyRunnable implements Runnable {
     
    private String name;
   
    public MyRunnable(String name){
        this.name = name;
    }
    
    public void run(){
        for(int i =0;i<500;i++){
            System.out.println(name + ":"+ i);
        }
    }
    

}
