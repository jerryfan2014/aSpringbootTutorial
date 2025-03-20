package com.kangda.pre.annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
public class AnnotationParser {
    public static void main(String[] args) throws Exception {
        // 获取类的注解
        Class<?> clazz = AnnotationUser.class;
        Author classAnnotation = clazz.getAnnotation(Author.class);
        if (classAnnotation != null) {
            System.out.println("Class Author: " + classAnnotation.name());
            System.out.println("Class Date: " + classAnnotation.date());
        }
        // 获取字段的注解
        Field field = clazz.getDeclaredField("strField");
        Author fieldAnnotation = field.getAnnotation(Author.class);
        if (fieldAnnotation != null) {
            System.out.println("Field Author: " + fieldAnnotation.name());
            System.out.println("Field Date: " + fieldAnnotation.date());
        }
        // 获取方法的注解
        Method method = clazz.getMethod("foo");
        Author methodAnnotation = method.getAnnotation(Author.class);
        if (methodAnnotation != null) {
            System.out.println("Method Author: " + methodAnnotation.name());
            System.out.println("Method Date: " + methodAnnotation.date());
        }
    }
}
