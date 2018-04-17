package com.baizhi.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import com.baizhi.entity.User;

//用于检查User用户是否登录
public class LoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
		// 获取Session
		HttpServletRequest httpRequest = (HttpServletRequest) arg0;
		HttpSession session = httpRequest.getSession();

		User u = null;
		try {
			u = (User) session.getAttribute("user");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 用户未登录
		if (null == u) {
			RequestDispatcher dispatcher = arg0.getRequestDispatcher("/login.jsp");
			dispatcher.forward(arg0, arg1);
			return;
		}

		arg2.doFilter(arg0, arg1);
	}

	public void init(FilterConfig arg0) throws ServletException {
	}

}
