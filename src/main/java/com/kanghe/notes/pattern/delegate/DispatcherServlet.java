package com.kanghe.notes.pattern.delegate;

import lombok.Getter;
import lombok.Setter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 委派模式
 * 有点像代理模式，又有点像策略模式
 * 相当于是静态代理的一种非常特殊的情况，全权代理
 * 以Delegate结尾的类名，Dispatcher结尾的
 * 调度中心
 */
public class DispatcherServlet {

    private List<Handler> handlerMapping = new ArrayList<>();

    public DispatcherServlet() {
        this.handlerMapping.add(new Handler());
    }

    public void doService(HttpServletRequest request, HttpServletResponse response) {
        doDispatch(request, response);
    }

    private void doDispatch(HttpServletRequest request, HttpServletResponse response) {
        // 1、获取用户请求的URL，如果按照J2EE的标准，每个URL对应一个Servlet，URL由浏览器输入
        String uri = request.getRequestURI();
        // 2、Servlet拿到URL后，要做权衡
        // 3、通过拿到的URL去handlerMapping（我们把它认为是策略常量）
        Handler handler = null;
        for (Handler h : handlerMapping) {
            if (uri.equals(h.getUrl())) {
                handler = h;
                break;
            }
        }
        // 4、将具体的任务分发给Method，通过反射去调用其对应的方法
        Object obj = null;
        try {
            obj = handler.getMethod().invoke(handler.getController(), request.getParameter("mid"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 5、获取到Method执行的结果，通过Response返回出去
        try {
            response.getWriter().write((char[]) obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Getter
    @Setter
    class Handler {

        private Object controller;
        private Method method;
        private String url;

        public Handler() {

        }

        public Handler(Object controller, Method method, String url) {
            this.controller = controller;
            this.method = method;
            this.url = url;
        }

    }

}
