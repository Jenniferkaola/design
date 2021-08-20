package com.jennifer;

/**
 * ClassName HtmlFilter
 * author by jennifer
 * Date 2021/8/20
 */
//过滤前端的标签
class HtmlFilter implements Filter{

    @Override
    public Boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace("<","[").replace(">","]"));
        return true;
    }
}
