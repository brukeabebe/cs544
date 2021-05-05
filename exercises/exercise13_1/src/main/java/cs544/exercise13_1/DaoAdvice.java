package cs544.exercise13_1;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.util.StopWatch;


@Aspect
public class DaoAdvice {

	
	
	@Around("execution(* cs544.exercise13_1.CustomerDAO.*(..))")
	public Object invoke(ProceedingJoinPoint call ) throws Throwable { 
		 StopWatch sw = new StopWatch(); 
		 sw.start(call.getSignature().getName()); 
		 Object retVal = call.proceed(); 
		 sw.stop(); 
		 
		long totaltime = sw.getLastTaskTimeMillis(); 
	

		System.out.println(" time to execute save: " + totaltime + "ms");
		 
		return retVal; 
}
}
