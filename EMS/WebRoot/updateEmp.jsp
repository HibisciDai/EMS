<%@page import="javax.servlet.jsp.tagext.TryCatchFinally"%>
<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="com.baizhi.entity.*"%>
<%@page import="java.util.*"%>
<%@page import="com.baizhi.dao.impl.*"%>
<%
	//获取session user
	User u = (User)session.getAttribute("user"); 
	
	//获取传参user
	String id = "";
	Emp emp = null;
	EmpDAOImpl ud = new EmpDAOImpl();
	try {
		id = request.getParameter("id");	//用request得到 
		emp = ud.findById(Integer.parseInt(id));
	} catch (Exception e) {
		e.printStackTrace();
	}
 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DJ | update Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
                                	当前用户:<%=u.getAccount() %>
                                	<br />
                             	<a href="LoginOut">退出</a>
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="javascript:;">通讯录</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						update Emp info:
					</h1>
					<form action="UpdateEmp?id=<%=id %>" method="post" accept-charset="UTF-8">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="left">
									<input type="hidden" class="inputgri" name="id" value="1"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="name" value="<%=emp.getName()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="salary" value="<%=emp.getSalary()%>"/>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									birthday:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="birthday" value="<%=emp.getBirthdayString()%>"/>
								</td>
							</tr>
						</table>
						<p>
							<input type="submit" class="button" value=" 修改 &nbsp; &raquo;" />
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					百知教育2016-2017学年第二学期大作业 @author代槿
				</div>
			</div>
		</div>
	</body>
</html>
