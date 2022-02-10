package com.sy.exception.resolver;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sy.dto.Result;
import com.sy.exception.BusinessException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 自定义异常处理器类
 */
@Component
public class GlobalExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest req, HttpServletResponse res, Object o, Exception e) {
        //第三个参数：和拦截器中的Object对象一样，也是一个HandlerMethod对象，在这里表示出现异常的控制器类和对应方法
        //第四个参数：具体抛出的异常信息
        String errMsg = e.getMessage();
        Result<Void> result = new Result<>();
        result.setSuccess(false);
        if (e instanceof BusinessException) {
            result.setErrMsg(errMsg);
        }
//        if(e instanceof  xxxException){
//            xxxx
//        }
        else {
            result.setErrMsg("未知错误");
        }
        res.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        try {
            PrintWriter pw = res.getWriter();
            pw.println(new ObjectMapper().writeValueAsString(result));
        } catch (IOException e1) {
            e1.printStackTrace();
        }
        return null;
    }
}
