package com.kangda.pre.gt;


import com.kangda.pre.annotation.AutoLog;

@AutoLog(logMsg = "学生信息类")
public class Student {
    private String name;
    private Integer age;
//    M（Male）， F(Female)
//    Character
    private char sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }
//    添加相应的setter ，getter


    public Student(String name, Integer age, char sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public Student() {}

    public void printInfo(String msg) {
        System.out.println("printInfo:" + msg);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                '}';
    }
}
