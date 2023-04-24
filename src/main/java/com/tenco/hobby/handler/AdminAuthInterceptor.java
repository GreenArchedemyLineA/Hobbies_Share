package com.tenco.hobby.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.tenco.hobby.handler.exception.AdminUnAuthorizedException;
import com.tenco.hobby.handler.exception.UnAuthorizedException;
import com.tenco.hobby.repository.model.User;
import com.tenco.hobby.util.Define;

@Component
public class AdminAuthInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {

		HttpSession session = request.getSession();
		User principal = (User) session.getAttribute(Define.PRINCIPAL);

		if (principal == null) {
			throw new AdminUnAuthorizedException("관리자 로그인 먼저 해주세요.", HttpStatus.UNAUTHORIZED);
		}

		return true;

	}

}