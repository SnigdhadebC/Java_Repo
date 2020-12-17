package com.application;

public class ClientDemoUsingThread {
    public static void main(String[] args) {
        for(int i= 0 ; i < 20; i++)
        {
            System.out.println(Thread.currentThread().getName()+ " "+i);
        }

        // extending a Thread class
        MyThread myThread = new MyThread();
        myThread.start();
        System.out.println("## " +myThread.getState());

        // extending a Thread class
        MyThread1 myThread1 = new MyThread1();
        myThread1.start();

        System.out.println("----End of main method--------");

        // implementing a Runnable Interface
        Thread thread1 = new Thread(new Runnable() { // new stage
            @Override
            public void run() {
                Thread.currentThread().setName("Java-Thread1");
                Thread.currentThread().setPriority(1);
                System.out.println("Creating Thread using Runnable interface..."
                        +Thread.currentThread().getName());
                System.out.println("Id : "+Thread.currentThread().getId());
                System.out.println("Priority: "+Thread.currentThread().getPriority());
            }
        });
       // thread1.start();
        System.out.println("Thread1 is Alive: " +thread1.isAlive());
        System.out.println("Thread1 State: " +thread1.getState());


        System.out.println("-------Main---------");
        System.out.println(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getId());
        try{
            Thread.sleep(3000);

        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Priority of main: "+Thread.currentThread().getPriority());
        System.out.println("State of main: "+Thread.currentThread().getState()); //RUNNABLE
        System.out.println("Is Main thread ALIVE: "+Thread.currentThread().isAlive());

    }

}
