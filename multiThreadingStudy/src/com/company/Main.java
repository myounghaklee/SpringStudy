package com.company;

public class Main {

    public static void main(String[] args) {
	    Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //code that will run in a new Thread
                System.out.println("내가 어디 쓰레드 나면 : " + Thread.currentThread().getName());
                System.out.println("현재 쓰레드 우선순위는 : " + Thread.currentThread().getPriority());
            }
        });
        thread.setName("ENZO-쓰레드");
        thread.setPriority(Thread.MAX_PRIORITY);
        System.out.println("In thread : " + Thread.currentThread().getName() + "시작전 입니다.ㅇ ");
        thread.start();
        System.out.println("In thread : " + Thread.currentThread().getName() + "시작후~~~ ");

    }
}
