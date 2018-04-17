package com.baizhi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.baizhi.entity.User;
import com.baizhi.service.UserService;
import com.baizhi.service.impl.UserServiceImpl;

public class LoginIn extends HttpServlet {
	private UserService us = new UserServiceImpl(); // 持有service层引用，进行操作

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String username = request.getParameter("useraccount"); // 获取前台用户名
		String password = request.getParameter("userpassword"); // 获取前台密码
		String validationCode = request.getParameter("validationCode"); // 获取前台验证码
		String Code = (String) request.getSession().getAttribute("vcode"); // 获取后台session

		// 测试传参
		// System.out.println("前台获取：" + username);
		// System.out.println("前台获取:" + password);

		User u = null;
		if (Code.equals(validationCode)) { // 如果验证码匹配
		// if (true) {
			User getu = new User(username, password);
			// System.out.println("getu" + getu);
			try {
				u = us.login(getu); // 获取匹配登录信息的用户
				// System.out.println("u" + u);
			} catch (Exception e) {
				e.printStackTrace();
			}
			if (null != u) {
				// 登录成功
				// 保存user写入session
				System.out.println("登陆成功");
				HttpSession session = request.getSession();
				session.setAttribute("user", u);
				// 跳转
				response.sendRedirect(request.getContextPath() + "/ListEmp?pagesize=1");
			} else {
				// 登录失败
				System.out.println("未找到用户名或密码错误，登录失败");
				response.sendRedirect(request.getContextPath() + "/login.jsp");
			}
		} else {
			// 登录失败
			System.out.println("验证码错误");
			response.sendRedirect(request.getContextPath() + "/login.jsp");
		}
	}
}
