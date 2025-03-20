package com.kangda.pre.gt;

import java.util.ArrayList;
import java.util.List;

public class GTOne {

    public static void main(String[] args) {
//        List<Integer> objList = new ArrayList();
//        objList.add(2001); //new Intger(1000)
//        objList.add(2002);

        List<Student>  studList= new ArrayList();
        studList.add(new Student("tom", 18, 'M'));
        studList.add(new Student("lisa", 18, 'F'));
//经典的for写法
        for (int i = 0; i < studList.size(); i++) {
            Student stu = studList.get(i);
            System.out.println(stu.toString());
        }

//        增强型for写法 ，for-each
        for(Student stu: studList) {
            System.out.println(stu.toString());
        }
//labmda表达式 -> 箭头函数 （） -> {}
        studList.forEach(stu -> {
            System.out.println(stu.toString());
        });


    }
}
