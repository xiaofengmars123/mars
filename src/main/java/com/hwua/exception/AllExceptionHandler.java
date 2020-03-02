package com.hwua.exception;

import com.alibaba.fastjson.support.spring.FastJsonJsonView;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice/*全局異常处理类*/
public class AllExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ModelAndView handlerException(Exception ex, HttpServletRequest request, HttpServletResponse response) throws Exception{
        System.out.println("全局异常处理方法.....");
        SysException se = null;
        //假如我们收到的异常是自定义异常，直接转换成自定义异常
        if (ex instanceof SysException) {
            se = (SysException) ex;
        } else {//假如收到的异常不是我们自定义的异常，我们把错误信息直接放到我们自定义的异常中即可
            String exMessage = ex.getMessage();
            se = new SysException(exMessage);
        }
        if(isAjax(request)){
            ModelAndView mv = new ModelAndView();
            FastJsonJsonView view = new FastJsonJsonView();
            Map<String,Object> map = new HashMap<>();
            map.put("code","5000");
            map.put("message",se.getMessage());
            view.setAttributesMap(map);
            mv.setView(view);
            return mv;//直接把model中的数据以json格式进行写到客户端浏览器{code:5000,message:xxxxx}

        }else{
            ModelAndView mv = new ModelAndView();
            mv.addObject("error", se.getMessage());
            mv.setViewName("error");
            return mv;
        }


    }

    /**
     * 判断是否是ajax请求
     * @param request
     * @return
     */
    private boolean isAjax(HttpServletRequest request) {
        return (request.getHeader("X-Requested-With") != null && request.getHeader("X-Requested-With").toString().equals("XMLHttpRequest"));
    }

}
