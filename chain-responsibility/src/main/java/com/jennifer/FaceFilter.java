package com.jennifer;

/**
 * ClassName FaceFilter
 * author by jennifer
 * Date 2021/8/20
 */
//替换笑脸
class FaceFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace(":)","kukuku"));
        return true;
    }
}