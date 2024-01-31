package edu.jeiu.diary_pjt.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogAOP {

	// edu 패키지 내 메소드 실행 시 AOP 적용 
	@Around("execution(* edu..*.*(..))")
	public Object loggerAOP(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
	
		// AOP를 적용하는 클래스명.메소드명을 변수에 할당
		String signatureString = proceedingJoinPoint.getSignature().toShortString();
		
		// 메소드 시작 로그
		long startTime = System.currentTimeMillis();
		System.out.println( signatureString + " is start");
		
		// 대상 객체 실행
		Object object = (Object) proceedingJoinPoint.proceed();
		
		// 메소드 시작 로그
		long endTime = System.currentTimeMillis();
		System.out.println( signatureString + " is end " + ", 실행시간(ms) : " + (endTime - startTime));

		return object;

	}
	
}
