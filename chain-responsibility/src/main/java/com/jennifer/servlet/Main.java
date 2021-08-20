package com.jennifer.servlet;

import com.jennifer.Filter;
import com.jennifer.FilterChainMain;

import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Mian
 * author by jennifer
 * Date 2021/8/20
 * 实现类似servlet中filter接口的doFilter(request,response,filterChain的方法)
 */
public class Main {

    public static void main(String[] args) {

        Request request = new Request();
        request.setMsg("<script>hello everyone :)</script>,欢迎来到996的世界");
        Response response = new Response();
        response.setMsg("[script]hello everyone kukukku[/script],欢迎来到955的世界");

        FilterServletChain filterChain = new FilterServletChain();
        FilterServletChain filterChain1 = new FilterServletChain();
        filterChain1.add(new FaceServletFilter());
        filterChain.add(new HtmlServletFilter()).add(new SensitiveServletFilter()).add(filterChain1);

        filterChain.doFilter(request,response,filterChain);
        System.out.println(request);
        System.out.println(response);

    }
}

//请求对象
class Request{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Request{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

//响应对象
class Response{
    private String msg;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Response{" +
                "msg='" + msg + '\'' +
                '}';
    }
}

//模拟filterChain类
class FilterServletChain implements ServletFilter{

    private int index = 0;

    private List<ServletFilter> filters = new ArrayList<>();
    public FilterServletChain add(ServletFilter filter){
        filters.add(filter);
        return this;
    }

    //类似使用到了递归模式
    @Override
    public boolean doFilter(Request request, Response response, FilterServletChain filterChain) {
       if (index >= filters.size()) return false;
       index ++;
       filters.get(index - 1).doFilter(request,response,filterChain);
       return true;
    }
}

interface ServletFilter{
    boolean doFilter(Request request,Response response,FilterServletChain filterChain);
}

class HtmlServletFilter implements ServletFilter{

    @Override
    public boolean doFilter(Request request, Response response, FilterServletChain filterChain) {
        request.setMsg(request.getMsg().replace("<","[").replace(">","]"));
        //实现filterChain的递归调用
        filterChain.doFilter(request,response,filterChain);
        response.setMsg(response.getMsg().replace("[","<").replace("]",">"));
        return true;
    }
}

class SensitiveServletFilter implements ServletFilter{

    @Override
    public boolean doFilter(Request request, Response response, FilterServletChain filterChain) {
        request.setMsg(request.getMsg().replace("996","955"));
        filterChain.doFilter(request,response,filterChain);
        response.setMsg(response.getMsg().replace("955","996"));
        return true;
    }
}

class FaceServletFilter implements ServletFilter{

    @Override
    public boolean doFilter(Request request, Response response, FilterServletChain filterChain) {
        request.setMsg(request.getMsg().replace(":)","kukukku"));
        filterChain.doFilter(request,response,filterChain);
        response.setMsg(response.getMsg().replace("kukukku",":)"));
        return true;
    }
}
