package com.Ex.lambdaEx;

public class MaxNumberTest {
    public static void main(String[] args) {
        MaxNumber m = (x,y) -> (x>=y)? x : y;
        System.out.println(m.getMaxNumber(10,20));
    }
}
