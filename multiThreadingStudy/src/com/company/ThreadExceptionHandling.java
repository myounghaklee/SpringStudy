package com.company;

public class ThreadExceptionHandling {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                throw new RuntimeException("internal exception");
            }
        });

        thread.setName("error thread");
        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler(){

            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("chritical error occred in thread" + t.getPriority() + " thread name : " + t.getName() + "error is : " + e.getMessage());
            }
        });
        thread.start();
    }
}


/*
 Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

            }
        });
 */