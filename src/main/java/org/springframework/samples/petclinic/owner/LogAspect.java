package org.springframework.samples.petclinic.owner;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

//스프링이 제공해주는 애노테이션 기반의 aop
//내부는 프록시 법칙으로 적용되는것

@Component //빈으로 등록되어야하기 때문에
@Aspect //애노테이션을 읽어서 처리해주는 것
public class LogAspect {

	Logger logger = LoggerFactory.getLogger(LogAspect.class);

	//이 어노테이션을 사용하면 joinPoint라는 파라미터를 받을 수 있음
	//조인포인트는 해당 애노테이션이 붙어있는 메서드(@ExecutionTime)
	//이 문장을 해석하자면 logExecutionTime이라는 애노테이션이 붙어있는곳 근처에
	//아래 코드를 적용하겠다는 의미임
	@Around("@annotation(LogExecutionTime)")

	public  Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		//해당 메서드 실행부분
		Object proceed = joinPoint.proceed();

		stopWatch.stop();
		logger.info(stopWatch.prettyPrint());

		return proceed;
	}
}
