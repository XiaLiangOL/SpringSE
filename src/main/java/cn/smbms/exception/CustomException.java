package cn.smbms.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 异常处理器实现类
 * 
 * @author 梁
 *
 */
public class CustomException implements HandlerExceptionResolver {
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
		System.out.println("e");
		// handler,是发生异常的地方，包括包，类，方法，形参
		ModelAndView mav = new ModelAndView();
		mav.addObject("error", handler.toString() + "发生异常");
		mav.setViewName("error");
		return mav;
	}
	
}
