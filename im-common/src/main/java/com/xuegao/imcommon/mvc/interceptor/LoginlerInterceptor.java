package com.xuegao.imcommon.mvc.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <br/> @PackageName：com.cherrys.schooldemo.interceptor
 * <br/> @ClassName：LoginlerInterceptor
 * <br/> @Description：
 * <br/> @author：xuegao
 * <br/> @date：2020/7/16 11:28
 */
public class LoginlerInterceptor implements HandlerInterceptor {

    // 正常顺序preHandler返回true情况下是先preHandler、postHandle、afterCompletion
    // 返回false就直接跳过postHandle.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*该方法将在请求处理之前进行调用，只有该方法返回true，才会继续执行后续的Interceptor和Controller，
        当返回值为true 时就会继续调用下一个Interceptor的preHandle 方法，
        如果已经是最后一个Interceptor的时候就会是调用当前请求的Controller方法；*/
        System.out.println(" LoginlerInterceptor " + request.getParameterMap());
        String token = request.getParameter("token");

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        /*该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束之后，
        也就是在DispatcherServlet 渲染了对应的视图之后执行。用于进行资源清理。*/
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        /*该方法将在请求处理之后，DispatcherServlet进行视图返回渲染之前进行调用，
        可以在这个方法中对Controller 处理之后的ModelAndView 对象进行操作。*/
    }
}