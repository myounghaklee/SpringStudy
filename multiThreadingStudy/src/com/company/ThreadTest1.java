package com.company;

public class ThreadTest1 {
    public static void main(String[] args) {

    }

    private static class Vault{
        private int password;
        public Vault(int password){
            this.password = password;
        }
        public boolean isCorrectPassword(int guess){
            try{
                Thread.sleep(5);
            }catch (InterruptedException e){

            }
            return this.password == guess;
        }
    }

    private static abstract class HackerThread extends  Thread{
        protected Vault v;
        public HackerThread(Vault v){
            this.v = v;
            this.setName(this.getClass().getSimpleName());
            this.setPriority(Thread.MAX_PRIORITY);
        }
        @Override
        public void start(){
            System.out.println("start thead : " +this.getName());
            super.start();
        }
    }


}
