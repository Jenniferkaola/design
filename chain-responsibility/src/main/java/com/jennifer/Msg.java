package com.jennifer;

/**
 * ClassName Msg
 * author by jennifer
 * Date 2021/8/20
 */
class Msg{
    String msg;
    void setMsg(String msg){
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "msg='" + msg + '\'' +
                '}';
    }
}