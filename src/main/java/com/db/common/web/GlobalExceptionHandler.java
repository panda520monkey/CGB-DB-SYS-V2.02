package com.db.common.web;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.db.common.exception.ServiceException;
import com.db.common.vo.JsonResult;
/**
 * @ControllerAdvice 注解描述的类
 * 为一个全局异常处理类,在此类中可以
 * 定义具体的异常处理方法处理相关异常
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
   /*@ExceptionHandler(ServiceException.class)
	 @ResponseBody
	 public JsonResult doHandleServiceException(
			 ServiceException e){
	    	e.printStackTrace();
			return new JsonResult(e);
	 }*/
	/**
	 * @ExceptionHandler 注解描述的方法为一个
	 * 异常处理方法
	 * @param e
	 * @return
	 */
    @ExceptionHandler(RuntimeException.class)
	@ResponseBody
    public JsonResult doHandleRuntimeException(
			RuntimeException e){
    	e.printStackTrace();
		return new JsonResult(e);
	}
}





