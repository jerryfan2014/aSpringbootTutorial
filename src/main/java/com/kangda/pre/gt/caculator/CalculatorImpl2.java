package com.kangda.pre.gt.caculator;

public class CalculatorImpl2 implements Calculator<Integer>{

    @Override
    public Integer add(Integer a, Integer b) {
        return a + b;
    }
    @Override
    public Integer minus(Integer a, Integer b) {
        return a - b;
    }
    @Override
    public Integer multiply(Integer a, Integer b) {
        return a * b;
    }
    @Override
    public Integer divide(Integer a, Integer b) {
//        安全性检查
        if(b == 0) {
//            throw
        }
        return a / b;
    }
    public static void main(String[] args) {
        CalculatorImpl2 cal = new CalculatorImpl2();
        System.out.println(cal.add(100,200));
    }
}
