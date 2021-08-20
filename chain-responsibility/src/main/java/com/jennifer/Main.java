package com.jennifer;

import javax.rmi.ssl.SslRMIClientSocketFactory;
import java.util.ArrayList;
import java.util.List;

/**
 * ClassName Main
 * author by jennifer
 * Date 2021/8/20
 * 责任链模式
 */
public class Main {
    public static void main(String[] args) {

        Msg msg = new Msg();
        msg.setMsg("<script>Hello everybody:)</script>,欢迎来到996的世界");

        List<Filter> filters = new ArrayList<>();
        filters.add(new HtmlFilter());
        filters.add(new SensitiveFilter());

        for (Filter filter : filters){
            filter.doFilter(msg);
        }

        System.out.println(msg);
    }
}










