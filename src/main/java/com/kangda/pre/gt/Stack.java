package com.kangda.pre.gt;
import java.util.ArrayList;
import java.util.List;

public class Stack<T> {
//    1,需要一个存放数据的结构，用来存放入栈的数据 List
//    2，实现push-> add (追加）
//    pop方法 lastIndex size()-1
//    isEmpty -> isEmpty
//    singleton 单件
    private List<T> objList = new ArrayList() ;
    public void push(T obj) {
        objList.add(obj); //默认在List末尾添加元素， append
    }
    public T pop(){
//        栈是否为空，如果为空，抛出异常(RuntimeException)
        if (objList.isEmpty()) {
            throw new IndexOutOfBoundsException("我已经空了！");
        }

        //用item暂存栈顶元素
        T item = objList.get(objList.size() - 1);
        objList.remove(objList.size() - 1);
        return item;
    }

//    static method 静态方法
//    public static <T> boolean isEmpty(List<T> list){
//        return list.isEmpty();
//    }

    public boolean isEmpty(){
        return objList.isEmpty();
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack();
        System.out.println(stack.pop());

        stack.push("AAAA");
        stack.push("BBBB");
        stack.push("CCCC");
        String item = stack.pop();
        System.out.println(item);
        System.out.println(stack.pop());
        Stack<Student> studentStack = new Stack<>();
        studentStack.push(new Student("tim", 20, 'M'));
        studentStack.push(new Student("jenny", 20, 'F'));
        studentStack.push(new Student("frank", 21, 'M'));
        System.out.println(studentStack.pop().getName());
    }
}
