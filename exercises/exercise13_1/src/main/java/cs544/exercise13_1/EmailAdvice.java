package cs544.exercise13_1;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;



@Aspect
public class EmailAdvice {

	


	@After("execution(* cs544.exercise13_1.EmailSender.sendEmail(..)) && args(email,message)")
	public void sendEmailaftermethod(JoinPoint joinpoint, String email, String message) {
		EmailSender emailSender = (EmailSender)joinpoint.getTarget();
		
		

		//LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("Fri Jun 05 14:09:47 GMT 2009  " + "method=" + joinpoint.getSignature().getName() +
				"  address=" + email  + "\n"+
				"message=" + message + " " + "\n"+
				"outgoing email Server  ="+ emailSender.getOutgoingMailServer());
		
	}
}
