<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="com.baizhi.entity.*"%>
<%@page import="java.util.*"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
User u = (User)session.getAttribute("user"); 
List empList = new ArrayList<Emp>();
empList = (List)session.getAttribute("empList");

//Integer countrow = new Integer(50);
//Integer pagesize = new Integer(1);
//Integer pagecontent = new Integer(10);

//out.print("countrow:" + (Integer)session.getAttribute("countrow"));
//out.print("pagesize:" + (Integer)session.getAttribute("pagesize"));
//out.print("pagecontent:" + (Integer)session.getAttribute("pagecontent"));

Integer countrow = (Integer)session.getAttribute("countrow");
Integer pagesize = (Integer)session.getAttribute("pagesize");
Integer pagecontent = (Integer)session.getAttribute("pagecontent");

//int countrow = Integer.parseInt((String)session.getAttribute("countrow"));
//int pagesize = Integer.parseInt((String)session.getAttribute("pagesize"));
//int pagecontent = Integer.parseInt((String)session.getAttribute("pagecontent"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DJ | emplist</title>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
	</head>
	<body>
		<div id="wrap">
			<div id="top_content"> 
				<div id="header">
						<div id="rightheader">
							<p>
                             	当前用户: <%=u.getAccount() %>
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
						Welcome!
					</h1>
					
					<table class="table">
						<tr class="table_header">
							<td>
								ID
							</td>
							<td>
								Name
							</td>
							<td>
								Salary
							</td>
							<td>
								birthday
							</td>
							<td>
								Operation
							</td>
						</tr>
						<%
							for (int i=0; i<empList.size(); i++) {
								Emp e = (Emp)empList.get(i);
						%>
								<tr <%if (i%2 == 0) {%>class="row1"<%} else {%>class="row2"<%}%>>
									<td>
										<%=e.getId() %>
									</td>
									<td>
										<%=e.getName() %>
									</td>
									<td>
										<%=e.getSalary() %>
									</td>
									<td>
										<%=e.getBirthdayString() %>
									</td>
									<td>
										<a href="updateEmp.jsp?id=<%=e.getId()%>">修改</a>&nbsp;<a href="DeleteEmp?id=<%=e.getId()%>">删除</a>
									</td>
								</tr>
						<%}%>
					</table>
					
					<form action="ListEmp" method="post" accept-charset="UTF-8">
						<div id="navigation2">
							共第<font style="color: black"><%=countrow %></font>条 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							第<font style="color: black">10</font>条/页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							第<font style="color: black"><%=pagesize %></font>页 &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							共<font style="color: black"><%=pagecontent %></font>页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="ListEmp?pagesize=1">首页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%
								if(pagesize > 1) {%>
									<a href="ListEmp?pagesize=<%=pagesize-1 %>">[上一页]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%	} else {
							%>
									[上一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%
								}
							%>
							<%
								if(pagesize < pagecontent) {%>
									<a href="ListEmp?pagesize=<%=pagesize+1 %>">[下一页]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%	} else {
							%>
									[下一页]&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							<%
								}
							%>
							<a href="ListEmp?pagesize=<%=pagecontent %>">[尾页]</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
							
							转到第
							<select name="pagesize">
								<%
									for (int i=1; i<=pagecontent; i++) {
								%>
										<option value="<%=i %>" <%if(pagesize == i)out.print("selected"); %> ><%=i %></option>
								<%		
									}
								%>
							</select>
							页&nbsp;
							<input type="submit" name="submit" value="提交">
						</div>
					</form>
					<br>
					
					<p>
						<a href="addEmp.jsp">添加联系人</a>
					</p>
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
