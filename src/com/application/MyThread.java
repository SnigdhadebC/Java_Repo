package com.application;

public class MyThread extends Thread{
    @Override
    public void run(){
        // this will be executed once the thread is started
        for(int i = 0; i < 20 ; i++){
            Thread.currentThread().setPriority(10); // max priority
            System.out.println(Thread.currentThread().getName() +" "+ i);//Thread-0
        }

    }

}
