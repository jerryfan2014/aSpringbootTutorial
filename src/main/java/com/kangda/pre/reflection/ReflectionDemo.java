package com.kangda.pre.reflection;
import com.kangda.pre.annotation.AutoLog;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionDemo {

    public static void main(String[] args) {
//        Class<?> clazz  =  Student.class;
//        Class<?> clazz2  =  new Student().getClass();
//        System.out.println(clazz);
//        System.out.println(clazz2);
        try {
//            类名必须是全路径（包含完整的包名，不能只是一个孤零零的类名
            Class<?> clazz3 = Class.forName("com.kangda.pre.gt.Student");
            Object student = clazz3
                    .getDeclaredConstructor(String.class, Integer.class, char.class)
                    .newInstance("thomas", 28, 'M');
            Method  getMethod = clazz3.getDeclaredMethod("getName");
            Object value= getMethod.invoke(student);
            System.out.println(value);
            Field ageField = clazz3.getDeclaredField("age");
            ageField.setAccessible(true);
            System.out.println(ageField.get(student));
            //通过反射机制 调用 student.printInfo()方法

            Method printMethod = clazz3.getDeclaredMethod("printInfo", String.class);
            printMethod.invoke(student, "这是printInfo方法");

            AutoLog ann = clazz3.getAnnotation(AutoLog.class);
            //clazz3.getAnnotations()
            if (ann != null) {
                //用sout 模拟生成文件
                System.out.println(ann.logMsg());
            }

//            clazz3.getDeclaredM

        } catch (ClassNotFoundException |
                 NoSuchMethodException |
                 InstantiationException |
                 IllegalAccessException |
                 InvocationTargetException |
                 NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
