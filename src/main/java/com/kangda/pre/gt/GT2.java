package com.kangda.pre.gt;

public class GT2 {


    public <T> void printItem(T[] arr) {
//        return (T) box.getItem();
        for (T item: arr) {
            System.out.println(item);
        }
    }

    public static void main(String[] args) {
        String[] strArr = {"tim","cicilia","tom"};
        GT2 gt2 = new GT2();
        gt2.printItem(strArr);

        Integer intArr[] = {100,200,300};
        gt2.printItem(intArr);

    }
}
