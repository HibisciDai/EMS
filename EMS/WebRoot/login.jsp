<%@ page pageEncoding="utf-8" contentType="text/html;charset=utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>DJ | login</title>
		<base href="<%=basePath%>">
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<script type="text/JavaScript">
			function oncheck1() {
		    	var account = document.getElementById("useraccount").value;	//记录用户名
				var password = document.getElementById("userpassword").value;	//记录密码
				var vcode = document.getElementById("vcode");	//记录验证码
				var accounttip = document.getElementById("accounttip");		//用户名信息

				accounttip.style.display = 'none';

				if (account == null || account == '') {
					accounttip.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (account != null & account != '' & password != null & password != '' & vcode != null & vcode != '') {
					document.getElementById('submitbutton').disabled = false;
				}
	    	}

	    	function oncheck2() {
		    	var account = document.getElementById("useraccount").value;	//记录用户名
				var password = document.getElementById("userpassword").value;	//记录密码
				var vcode = document.getElementById("vcode");	//记录验证码
				var passwordtip = document.getElementById("passwordtip"); 		//密码信息

				passwordtip.style.display = 'none';

				if (password == null || password == '') {
					passwordtip.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (account != null & account != '' & password != null & password != '' & vcode != null & vcode != '') {
					document.getElementById('submitbutton').disabled = false;
				}
	    	}

	    	function oncheck3() {
		    	var account = document.getElementById("useraccount").value;	//记录用户名
				var password = document.getElementById("userpassword").value;	//记录密码
				var vcode = document.getElementById("vcode").value;	//记录验证码
				var vcodetip = document.getElementById("vcodetip");		//验证码信息

				vcodetip.style.display = 'none';

				if (vcode == null || vcode == '') {
					vcodetip.style.display = 'inline';
					document.getElementById('submitbutton').disabled = true;
				}

				if (account != null & account != '' & password != null & password != '' & vcode != null & vcode != '') {
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
							<p><br/></p>
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
						登录
					</h1>
					<form action="loginIn" method="post" accept-charset="UTF-8">
						<table cellpadding="0" cellspacing="0" border="0" class="form_table">
							<tr>
								<td valign="middle" align="right">
									用户名:
								</td>
								<td valign="middle" align="left">
									<input id="useraccount" type="text" class="inputgri" name="useraccount" autocomplete="off" onblur="oncheck1();" />
								</td>
								<td>
									<span id="accounttip" style="display: none">未输入用户名</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									密码:
								</td>
								<td valign="middle" align="left">
									<input id="userpassword" type="password" class="inputgri" name="userpassword" autocomplete="off" onblur="oncheck2();" />
								</td>
								<td>
									<span id="passwordtip" style="display: none">未输入密码</span>
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									验证码:
								</td>
								<td valign="middle" align="left">
									<input id="vcode" type="text" class="inputgri" name="validationCode" autocomplete="off" onblur="oncheck3();" />
								</td>
								<td valign="middle" align="left">									
									<!-- <img  src="${pageContext.request.contextPath}/GetCaptcha"> -->
									<img id="codeimg" src="GetCaptcha">
								</td>
								<td>
									<span id="vcodetip" style="display: none">未输入验证码</span>									
								</td>
							</tr>
						</table>
						<p>
							<input id="submitbutton" type="submit" class="button" value="登录 &nbsp; &raquo; " disabled/>
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
