package pers.you.java.multithreading;

public class MyThread extends Thread {

    private String name;

    public MyThread(String name) {
        this.name = name;
    }
    public void run() {

        for (int i = 0; i < 500; i++) {
            System.out.println(name + ":" + i);
        }
        super.run();

    }

}
