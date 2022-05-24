package com.company;

import java.math.BigInteger;

public class ThreadInterrupt {
    public static void main(String[] args) {
        Thread thread = new Thread(new LongComputationtask(new BigInteger("200000"), new BigInteger("100000000")));
        thread.start();
        thread.interrupt();

    }

    private static class LongComputationtask implements Runnable {
        private BigInteger base;
        private BigInteger power;
        public LongComputationtask(BigInteger bigInteger, BigInteger bigInteger1) {
            this.base = bigInteger;
            this.power = bigInteger1;
        }
        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base,power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;

            for(BigInteger i = BigInteger.ZERO; i.compareTo(power)!=0; i=i.add(BigInteger.ONE)){
                if(Thread.currentThread().isInterrupted()){
                    System.out.println("이미 인터룹트 됬지롱");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }
            return result;
        }
    }
}
