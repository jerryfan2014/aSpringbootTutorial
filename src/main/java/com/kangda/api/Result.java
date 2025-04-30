package com.kangda.api;

//对后端返回的数据统一封装
public class Result<T> {
    private  final static int SUCCESS = 0;
    private  final static int ERROR = 1;
    //操作码
    private int code;
    //消息
    private String msg;
    //数据
    private T data;
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    public Result() {    }
    //操作成功，但不需要返回任何数据
    public static Result success(){
        return new Result(SUCCESS, "操作成功", null);
    }

    public static Result success(String msg){
        return new Result(SUCCESS, msg, null);
    }
    //操作失败，返回错误消息
    public static Result error(String errMsg){
        return new Result(ERROR, errMsg, null);
    }
    //操作成功，返回数据，数据是泛型
    public static <T> Result<T> success(T data){
        return new Result(SUCCESS, "操作成功", data);
    }
}
