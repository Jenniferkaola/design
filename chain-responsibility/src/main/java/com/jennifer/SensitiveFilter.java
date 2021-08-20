package com.jennifer;

/**
 * ClassName SensitiveFilter
 * author by jennifer
 * Date 2021/8/20
 */

//过滤敏感词
class SensitiveFilter implements Filter{
    @Override
    public Boolean doFilter(Msg msg) {
        msg.setMsg(msg.getMsg().replace("996","955"));
        return true;
    }
}
