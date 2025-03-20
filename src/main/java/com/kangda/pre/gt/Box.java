package com.kangda.pre.gt;

import java.util.List;

public class Box<T> {
    private T item;

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Box(T item) {
        this.item = item;
    }


    public void printItem(List<Box<T>> boxList) {
//        return (T) box.getItem();
        for (Box<T> box: boxList) {
            System.out.println(box.getItem());
        }
    }

    public static void main(String[] args) {
//        Box<String> strBox = new Box();
        Box<String> strBox = new Box<>("Hello");
        Box<String> strBox2 = new Box<>("Hiiii");
        Box<Integer> intBox = new Box<>(100);
        Box<Student> studentBox = new Box<>(new Student("kelvin", 19, 'M'));

//        Box<String>[] strBoxArr = {strBox, strBox2};
//        List<Box<?> boxList = new ArrayList<>();
//        boxList.add(strBox);
//        boxList.add(strBox2);
//        printItem(boxList);

        System.out.println(strBox.getItem());
        System.out.println(studentBox.getItem());

    }
}
