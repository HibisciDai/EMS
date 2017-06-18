package com.baizhi.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import com.baizhi.service.impl.EmpServiceImpl;

public class AddEmp extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public AddEmp() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");		//设置编码格式
		response.setCharacterEncoding("UTF-8");		//设置编码格式
		
		String name = request.getParameter("name");
		String getsalary = request.getParameter("salary");
		String birthday = request.getParameter("birthday");
		
		int salary = Integer.parseInt(getsalary);
//		java.sql.Date birthday = new java.sql.Date(new java.util.Date(getbirthday).getTime());
		
//		Date birthday = new Date(getbirthday);
		
//		System.out.println(birthday);	//测试数据
		
		EmpService es = new EmpServiceImpl();
		Emp e = new Emp(name, salary, birthday);
		es.save(e);
		
		response.sendRedirect(request.getContextPath() + "/ListEmp?pagesize=1");
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
