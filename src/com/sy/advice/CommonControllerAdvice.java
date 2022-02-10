package com.sy.advice;

import com.fasterxml.jackson.core.JsonParseException;
import com.sy.dto.JsonResult;
import com.sy.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingPathVariableException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

/**
 * 可以对项目中Controller层的方法进行切面编程
 * 1.在此处统一对Controller层出现的异常进行处理
 * 2.因为在Controller中层中对于结果的封装步骤差不多，所以也可以在这里统一封装结果
 * basePackages-这里指定只处理自定义的Controller包下的控制器
 */
@ControllerAdvice(basePackages = "com.sy.controller")
@ResponseBody
public class CommonControllerAdvice implements ResponseBodyAdvice {
    @Autowired(required = false)
    private HttpServletResponse res;

    @ExceptionHandler(BusinessException.class)
    public JsonResult handleBusinessException(BusinessException e) {
        e.printStackTrace();
        int status = e.getStatus().value();
        res.setStatus(status);
        return new JsonResult().setCode(status).setErrMsg(e.getMessage());
    }

    /**
     * 方法名:   handlerServerInternalException<br>
     * 方法描述: 出现服务器异常，即500错误时写出JSON数据<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:17<br>
     * 参数列表:<br>
     *        @param e 出现服务器异常，即500错误时的具体错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      出现服务器异常，即500错误时的具体错误信息时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(Exception.class)
    public JsonResult handlerServerInternalException(Exception e) {
        e.printStackTrace();
        int code = HttpStatus.INTERNAL_SERVER_ERROR.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg("服务器内部异常");
    }

    /**
     * 方法名:   handlerNotFoundStatus<br>
     * 方法描述: 用于在出现404错误的时候写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:05<br>
     * 参数列表:<br>
     *        @param e 404错误时具体的异常信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      出现404错误时JSON格式对应的Java对象<br>
     * 补充说明:<br>
     *      404默认不会抛出异常，需要配置<br>
     *      spring.mvc.throw-exception-if-no-handler-found=true<br>
     *      spring.resources.add-mappings=false<br>
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public JsonResult handlerNotFoundStatus(NoHandlerFoundException e) {
        int code = HttpStatus.NOT_FOUND.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg("请求资源" + e.getRequestURL() + "不存在");
    }

    /**
     * 方法名:   handleMissingServletRequestParameterException<br>
     * 方法描述: 用于在出现漏填必要参数的时候写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:05<br>
     * 参数列表:<br>
     *        @param e 漏填必要参数时具体的异常信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult 出现漏填必要参数时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public JsonResult handleMissingServletRequestParameterException(MissingServletRequestParameterException e) {
        e.printStackTrace();
        int code = HttpStatus.BAD_REQUEST.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg(e.getParameterType() + "类型的参数" + e.getParameterName() + "为必填参数");
    }

    /**
     * 方法名:   handleIllegalStateException<br>
     * 方法描述: 用于在出现例如入参为int，但是没传值，null不能转换为基本类型时写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:05<br>
     * 参数列表:<br>
     *        @param e 出现异常时的具体错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      出现错误时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(IllegalStateException.class)
    public JsonResult handleIllegalStateException(IllegalStateException e) {
        e.printStackTrace();
        int code = HttpStatus.BAD_REQUEST.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg(e.getMessage());
    }

    /**
     * 方法名:   handleMethodArgumentTypeMismatchException<br>
     * 方法描述: 入参格式出现错误的时候写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:10<br>
     * 参数列表:<br>
     *        @param e 参格式出现错误时的具体错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      入参格式出现错误时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public JsonResult handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException e) {
        e.printStackTrace();
        int code = HttpStatus.BAD_REQUEST.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg("参数" + e.getName() + "的格式有误");
    }

    /**
     * 方法名:   handleMissingPathVariableException<br>
     * 方法描述: RESTful风格的URL中缺失路径参数时写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:12<br>
     * 参数列表:<br>
     *        @param e RESTful风格的URL中缺失路径参数时的具体错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult RESTful风格的URL中缺失路径参数时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(MissingPathVariableException.class)
    public JsonResult handleMissingPathVariableException(MissingPathVariableException e) {
        e.printStackTrace();
        int code = HttpStatus.BAD_REQUEST.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg("路径中缺少名为" + e.getVariableName() + "的URI参数");
    }

    /**
     * 方法名:   handleHttpMessageNotReadableException<br>
     * 方法描述: 消息格式有问题时写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:13<br>
     * 参数列表:<br>
     *        @param e 消息格式有问题时具体错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      消息格式有问题时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public JsonResult handleHttpMessageNotReadableException(HttpMessageNotReadableException e) {
        e.printStackTrace();
        int code = HttpStatus.BAD_REQUEST.value();
        res.setStatus(code);
        JsonResult jsonResult = new JsonResult();
        jsonResult.setCode(code);
        if (e.getCause() instanceof JsonParseException) {
            jsonResult.setErrMsg("请检查JSON数据的格式是否正确");
        } else {
            jsonResult.setErrMsg("消息不可被读取，检查消息类型以及数据类型是否正确，具体错误信息");
        }
        return jsonResult;
    }

    /**
     * 方法名:   handleHttpRequestMethodNotSupportedException<br>
     * 方法描述: 使用的HTTP请求方法并不符合方法上声明的请求方法时写出错误信息<br>
     * 初始作者: 沈<br>
     * 创建日期: 2020/10/20 14:14<br>
     * 参数列表:<br>
     *        @param e 使用的HTTP请求方法并不符合方法上声明的请求方法时具体的错误信息<br>
     * 返回值:<br>
     *      com.meetingsystem.dto.JsonResult<br>
     *      使用的HTTP请求方法并不符合方法上声明的请求方法时JSON格式对应的Java对象<br>
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public JsonResult handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        e.printStackTrace();
        int code = HttpStatus.UNSUPPORTED_MEDIA_TYPE.value();
        res.setStatus(code);
        return new JsonResult().setCode(code).setErrMsg("使用的HTTP方法有误，当前方法支持的请求方式为：" + Arrays.toString(e.getSupportedMethods()));
    }

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        return true;
    }

    /**
     * 在Controller中的方法调用完毕后返回给前端之前进行统一处理
     * o-当前控制器方法执行后得到的返回类型
     */
    @Override
    public Object beforeBodyWrite(Object o, MethodParameter methodParameter, MediaType mediaType, Class aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        ServletServerHttpRequest req = (ServletServerHttpRequest) serverHttpRequest;
        ServletServerHttpResponse res = (ServletServerHttpResponse) serverHttpResponse;
        JsonResult jsonResult = new JsonResult();

        //所有错误信息会自动在异常处理中被包装为JsonResult类型进行返回
        //如果正常Controller中返回JsonResult类型，这里也可以直接处理
        if (o instanceof JsonResult) {
            jsonResult = (JsonResult) o;

        }
        //如果没有出现异常且控制器返回的结果也不是一个JsonResult类型，则在这里进行处理
        else {
            //获取请求方式
            HttpMethod method = req.getMethod();
            //根据请求方式封装最终的JSON返回结果
            if (method == HttpMethod.GET || method == HttpMethod.PUT || method == HttpMethod.PATCH) {
                jsonResult.setCode(HttpStatus.OK.value()).setData(o);
            }
            if (method == HttpMethod.POST) {
                jsonResult.setCode(HttpStatus.CREATED.value()).setData(o);
            }
            if (method == HttpMethod.DELETE) {
                //删除操作的方法返回布尔类型
                Boolean r = (Boolean) o;
                if (r) {
                    jsonResult.setCode(HttpStatus.NO_CONTENT.value()).setData(o);
                } else {
                    jsonResult.setCode(HttpStatus.NOT_FOUND.value()).setErrMsg("要删除的内容可能不存在");
                }
            }
        }
        //统一设置状态码
        res.setStatusCode(HttpStatus.valueOf(jsonResult.getCode()));
        return jsonResult;
    }
}
