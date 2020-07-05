package cn.smbms.tools;

import java.util.Arrays;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 增强处理类
 * 
 * @author 梁
 *
 */
public class AbnormalEnhancement {
	private static Logger logger = Logger.getLogger(AbnormalEnhancement.class);
	
	public void afterThrowing(JoinPoint jp, RuntimeException e) {
		logger.error(jp.getSignature().getName() + "方法发生异常：" + e);
		throw e;
	}
	
	/**
	 * 环绕增强
	 * 
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("环绕前=========》");
		logger.info("调用" + joinPoint.getTarget() + "的" + joinPoint.getSignature() + "方法。方法入参：" + Arrays.toString(joinPoint.getArgs()));
		try {
			
			Object proceed = joinPoint.proceed();// 执行目标方法并获取返回值
			logger.info("调用" + joinPoint.getTarget() + "的" + joinPoint.getSignature().getName() + "方法。返回值：" + proceed);
			logger.info("环绕后========》");
			return proceed;
		}
		catch (RuntimeException e) {
			logger.error(joinPoint.getSignature().getName() + "方法发生异常：" + e);
			e.printStackTrace();
			throw e;
		}
		finally {
			logger.info(joinPoint.getSignature().getName() + "方法结束执行。");
		}
		
	}
}
