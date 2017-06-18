<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%@page import="com.baizhi.entity.*"%>
<%
	//获取session user
	User u = (User)session.getAttribute("user"); 
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DJ | add Emp</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"	href="css/style.css" />
		<script type="text/JavaScript">
			function oncheck1() {
				var name = document.getElementById("name").value;
				var salary = document.getElementById("salary").value;
				var birthday = document.getElementById("birthday").value;

				var  re =/^(\d{4})-(\d{2})-(\d{2})$/; 	//判断日期格式符合YYYY-MM-DD标准 

				var nametip = document.getElementById("nametip");

				nametip.style.display = 'none';

				if (name == null || name == '') {
					nametip.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (name != null & name != '' & salary != null & salary != '' & birthday != null & birthday != '' & !isNaN(salary) & re.test(birthday) == true) {
					document.getElementById('submitbutton').disabled = false;
				}
	    	}

	    	function oncheck2() {
				var name = document.getElementById("name").value;
				var salary = document.getElementById("salary").value;
				var birthday = document.getElementById("birthday").value;

				var  re =/^(\d{4})-(\d{2})-(\d{2})$/; 	//判断日期格式符合YYYY-MM-DD标准 

				var salarytip = document.getElementById("salarytip");
				var salarytip2 = document.getElementById("salarytip2");

				salarytip.style.display = 'none';
				salarytip2.style.display = 'none';

				if (salary == null || salary == '') {
					salarytip.style.display = 'inline';
					salarytip2.style.display = 'none';
					document.getElementById('submitbutton').disabled = true;
				}

				if (isNaN(salary)) {
					salarytip.style.display = 'none';
					salarytip2.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (name != null & name != '' & salary != null & salary != '' & birthday != null & birthday != '' & !isNaN(salary) & re.test(birthday) == true) {
					document.getElementById('submitbutton').disabled = false;
				}
	    	}

	    	function oncheck3() {
		    	var name = document.getElementById("name").value;
				var salary = document.getElementById("salary").value;
				var birthday = document.getElementById("birthday").value;

				var  re =/^(\d{4})-(\d{2})-(\d{2})$/; 	//判断日期格式符合YYYY-MM-DD标准 

				var birthdaytip1 = document.getElementById("birthdaytip1");
				var birthdaytip2 = document.getElementById("birthdaytip2");

				birthdaytip1.style.display = 'none';
				birthdaytip2.style.display = 'none';

				if (birthday == null || birthday == '') {
					birthdaytip1.style.display = 'inline';
					birthdaytip2.style.display = 'none';
					document.getElementById('submitbutton').disabled = true;
				} else if (!re.test(birthday)) {
					birthdaytip1.style.display = 'none';
					birthdaytip2.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (name != null & name != '' & salary != null & salary != '' & birthday != null & birthday != '' & !isNaN(salary) & re.test(birthday) == true) {
					document.getElementById('submitbutton').disabled = false;
				}
	    	}


		</script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
                                	当前用户:<%=u.getAccount() %>
                                	<br />
                             	<a href="LoginOut">退出</a>
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="javascript:;">通讯录</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						add Emp info:
					</h1>
					<form action="AddEmp" method="post" accept-charset="UTF-8">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									name:
								</td>
								<td valign="middle" align="left">
									<input id="name" type="text" class="inputgri" name="name" onblur="oncheck1();"/>
								</td>
								<td>
									<span id="nametip" style="display: none">未输入姓名</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									salary:
								</td>
								<td valign="middle" align="left">
									<input id="salary" type="text" class="inputgri" name="salary" onblur="oncheck2();"/>
								</td>
								<td>
									<span id="salarytip" style="display: none">未输入工资</span>
									<span id="salarytip2" style="display: none">请输入数字</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									birthday:
								</td>
								<td valign="middle" align="left">
									<input id="birthday" type="text" class="inputgri" name="birthday" onblur="oncheck3();"/>
								</td>
								<td>
									<span id="birthdaytip1" style="display: none">未输入生日</span>
									<span id="birthdaytip2" style="display: none">生日格式不正确,YYYY-MM-DD格式</span>
								</td>
							</tr>
						</table>
						<p>
							<input id="submitbutton" type="submit" class="button" value=" 添加 &nbsp; &raquo; " disabled/>
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
