package com.kangda.pre.gt;


import java.lang.annotation.Documented;

public class GT3 {


//    实现泛型数组指定下标元素的互换
    public static <T> void swap(T[] arr, int i, int j) {
    //        参数合法性(有效性)检测
    // 1、 i和j 大于零
    //2、 i == j 没有意义
    //3、 i , j 不能越界（超出数组下标的最大值)

        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer intArr[] = {100,200,300,400,500};
        swap(intArr, 0,4);
        for(Integer obj:intArr) {
            System.out.println(obj);
        }
    }
}
