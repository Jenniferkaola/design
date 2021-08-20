package com.jennifer;

import com.sun.org.apache.xpath.internal.operations.Bool;

import javax.swing.text.MaskFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName FilterChainMain
 * author by jennifer
 * Date 2021/8/20
 * 将所有的filter串起来，链条式
 */
public class FilterChainMain {

    public static void main(String[] args) {
        Msg msg = new Msg();
        msg.setMsg("<script>Hello everybody :)</script>欢迎来到996的世界");
        FilterChain filterChain = new FilterChain();
        filterChain.add(new HtmlFilter()).add(new SensitiveFilter());


        //需要另一个链条时比较麻烦，可以选择filterChain也继承filter接口,filterChain1直接加入filterChain
        FilterChain filterChain1 = new FilterChain();
        filterChain1.add(new FaceFilter());
        //filterChain1.doFilter(msg);
        filterChain.add(filterChain1);
        filterChain.doFilter(msg);
        System.out.println(msg);

        //更具当前的过滤器返回结果判断下一个过滤器是否需要执行，还是直接返回?doFilter结果返回为Boolean类型,filterChain中根据返回值判断

    }
}

//最简单的链条
class FilterChain implements Filter{
    private List<Filter> filters = new ArrayList<>();

    //只要返回filterChain就可以实现类型replace的功能，编程技巧
    public FilterChain add(Filter filter){
        filters.add(filter);
        return this;
    }

    public Boolean doFilter(Msg msg){
        for (Filter filter : filters){
            if (!filter.doFilter(msg))
                return false;
        }
        return true;
    }
}

