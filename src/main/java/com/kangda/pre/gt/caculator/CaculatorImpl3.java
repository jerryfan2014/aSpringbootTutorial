package com.kangda.pre.gt.caculator;

public class CaculatorImpl3 implements Calculator<String>{
    @Override
    public String add(String a, String b) {
        return a + b;
    }

    @Override
    public String minus(String a, String b) {
        return a;
    }

    @Override
    public String multiply(String a, String b) {
        return a + a;
    }

    @Override
    public String divide(String a, String b) {
        return b+b;
    }
}
