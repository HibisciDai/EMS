package com.baizhi.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.baizhi.dao.EmpDAO;
import com.baizhi.dao.impl.EmpDAOImpl;
import com.baizhi.entity.Emp;

public class ListEmp extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ListEmp() {
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
		EmpDAO ed = new EmpDAOImpl();
		HttpSession session = request.getSession();
		
		String pagesize = request.getParameter("pagesize");
		int ps = Integer.parseInt(pagesize);
		List empList = new ArrayList<Emp>();
		
		empList = ed.initialize(ps);
		
		int pagesize1 = Integer.parseInt(pagesize);
		int countrow = ed.count();
		int pagecontent = 0;
		if (countrow % 10 == 0) {
			pagecontent = countrow/10;
		} else {
			pagecontent = countrow/10 + 1;
		}
		
		session.setAttribute("empList", empList);	//设置结果集
		session.setAttribute("pagesize", pagesize1);	//设置页数
		session.setAttribute("countrow", countrow);	//设置总条数
		session.setAttribute("pagecontent", pagecontent);		//总页数
		response.sendRedirect(request.getContextPath() + "/emplist.jsp");
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
