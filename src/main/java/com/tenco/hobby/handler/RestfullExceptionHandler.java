package com.tenco.hobby.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.tenco.hobby.handler.exception.AdminUnAuthorizedException;
import com.tenco.hobby.handler.exception.CustomRestfullException;
import com.tenco.hobby.handler.exception.UnAuthorizedException;

@RestControllerAdvice
public class RestfullExceptionHandler {
	@ExceptionHandler(Exception.class)
	public void exception(Exception e) {
		System.out.println(e.getClass().getName());
		System.out.println(e.getMessage());
	}

	@ExceptionHandler(CustomRestfullException.class)
	public String basicException(CustomRestfullException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("history.back();");
		sb.append("</script>");
		return sb.toString();
	}

	@ExceptionHandler(UnAuthorizedException.class)
	public String unAuthorizedException(UnAuthorizedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("location.href = \"/user/log-in\";");
		sb.append("</script>");
		return sb.toString();

	}
	
	@ExceptionHandler(AdminUnAuthorizedException.class)
	public String adminUnAuthorizedException(AdminUnAuthorizedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("location.href = \"/admin/login\";");
		sb.append("</script>");
		return sb.toString();
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public String noHandlerFoundException(NoHandlerFoundException e) {
		StringBuffer sb = new StringBuffer();
		if(e.getRequestURL().contains("/admin")) {
			sb.append("<script>");
			sb.append("alert('" + e.getMessage() + "');");
			sb.append("location.href = \"/error/admin\";");
			sb.append("</script>");
			return sb.toString();
		}else {
			sb.append("<script>");
			sb.append("alert('" + e.getMessage() + "');");
			sb.append("location.href = \"/error/user\";");
			sb.append("</script>");
			return sb.toString();
		}
	}
	
}
