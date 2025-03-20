package com.kangda.pre.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//注解的作用对象
@Target({ElementType.TYPE, ElementType.METHOD,ElementType.FIELD})
//注解的保留策略
@Retention(RetentionPolicy.RUNTIME)
public @interface Author {
    String name();
    String date() default "2025-11-11";
}
