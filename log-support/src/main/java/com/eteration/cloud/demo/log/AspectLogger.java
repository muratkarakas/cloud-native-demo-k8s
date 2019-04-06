package  com.eteration.cloud.demo.log;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectLogger {

	@Autowired(required = false)
	private HttpServletRequest req;
	
	@AfterReturning(pointcut = "execution(* com.eteration.cloud..controller.*.*(..))", returning = "returnVal")
	public void logMethodAccessAfter(JoinPoint joinPoint, Object returnVal) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());
		if(req != null) {
			print(req,logger);
		}
		StringBuilder sb = new StringBuilder("Rest execution Return => ");
		sb.append(joinPoint.getSignature());
		if (logger.isDebugEnabled() && returnVal != null) {
			sb.append(", Response: ");
			sb.append(returnVal.toString());

		}
		String log = sb.toString();
		logger.info(log);
	}

	
	private void print(HttpServletRequest request, Logger logger) {
		Enumeration headerNames = request.getHeaderNames();
		logger.info("---Http Headers---");
		while(headerNames.hasMoreElements()) {
		  String headerName = (String)headerNames.nextElement();
		  logger.info(headerName +" => "+request.getHeader(headerName));
		}
	}
	
	@Before("execution(* com.eteration.cloud..controller.*.*(..))")
	public void logMethodAccessBefore(JoinPoint joinPoint) {
		Logger logger = LoggerFactory.getLogger(joinPoint.getTarget().getClass());

		StringBuilder sb = new StringBuilder("Rest execution start => ");
		sb.append(joinPoint.getSignature());
		sb.append(", ARGS: ");
		sb = formatArgs(joinPoint, sb);
		String log = sb.toString();
		logger.info(log);
	}

	private StringBuilder formatArgs(JoinPoint jp, StringBuilder sb) {

		Object[] args = jp.getArgs();

		if (args != null && args.length > 0) {
			for (int i = 0; i < args.length; i++) {

				if (args[i] != null) {
					sb.append(i);
					sb.append(":");
					sb.append(args[i].toString());
					sb.append(" ");
				}
			}

		}else {
			sb.append("NOARGS");
		}

		return sb;

	}

}