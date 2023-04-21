package com.tenco.hobby.handler;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

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
	public String unAuUnAuthorizedException(UnAuthorizedException e) {
		StringBuffer sb = new StringBuffer();
		sb.append("<script>");
		sb.append("alert('" + e.getMessage() + "');");
		sb.append("location.href = \"/user/log-in\";");
		sb.append("</script>");
		return sb.toString();

	}

}
