package com.kangda.pre.annotation;


@Author(name ="thomas", date="2025-02-02")
@AnnotationSingle(value="Jim")
public class AnnotationUser {

    public static void main(String[] args) {
//        AnnotationUser an = new AnnotationUser();
//        System.out.println(an.foo());
        System.out.println(new AnnotationUser().foo());
    }

    @Author(name ="kelvin", date="2025-11-22")
//    @AnnotationSingle(value="Jim")
    private String strField;

    @Author(name ="sam", date="2025-03-72")
    public String foo(){
        return "foo";
    }
}
