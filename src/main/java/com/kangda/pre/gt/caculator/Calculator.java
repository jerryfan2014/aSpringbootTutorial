package com.kangda.pre.gt.caculator;

interface Calculator<T> {
    //    加
    T add(T a, T b);

    //    减法
    T minus(T a, T b);

    //    乘法
    T multiply(T a, T b);

    //    除法
    T divide(T a, T b);
}
