<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>尚硅谷会员注册页面</title>
		<%@include file="/pages/common/head.jsp" %>
		<style type="text/css">
			.login_form{
				height:420px;
				margin-top: 25px;
			}
			
		</style>
		<script type="text/javascript">
			$(function(){
				$("#username").blur(function(){
					
					var username = this.value;
					var namePatt = /^\w{5,12}$/;
					if(!namePatt.test(username)){
						$("span.errorMsg").text("用户名不合法~");
						return false;
					}else {
						$.getJSON("http://localhost:8080/book_second/userServlet", "action=ajaxExistUsername&username=" + username, function(data){
							if(data.existUsername){
								$("span.errorMsg").text("用户名已存在！");
							}else{
								$("span.errorMsg").text("用户名可用！");
							}
						});
					}
				});
				
				$("#sub_btn").click(function(){
					
					//检查用户名
					var username = $("#username").val();
					var namePatt = /^\w{5,12}$/;
					if(username.length == 0){
						$("span.errorMsg").text("用户名不能为空~");
						return false;
					}
					if(!namePatt.test(username)){
						$("span.errorMsg").text("用户名不合法~");
						return false;
					}
					//检查密码
					var password = $("#password").val();
					var pswPatt = /^\w{5,12}$/;
					if(password.length == 0){
						$("span.errorMsg").text("密码不能为空~");
						return false;
					}
					if(!pswPatt.test(username)){
						$("span.errorMsg").text("密码不合法~");
						return false;
					}
					//检查确认密码
					var repwd = $("#repwd").val();
					if(repwd.length == 0){
						$("span.errorMsg").text("确认密码不能为空~");
						return false;
					}
					if(repwd != password){
						$("span.errorMsg").text("两次密码不相同~");
						return false;
					}
					//检查邮箱
					var email = $("#email").val();
					var emailPatt = /^[a-z\d]+(\.[a-z\d]+)*@([\da-z](-[\da-z])?)+(\.{1,2}[a-z]+)+$/;
					if(email.length == 0){
						$("span.errorMsg").text("邮箱不能为空~");
						return false;
					}
					if(!emailPatt.test(email)){
						$("span.errorMsg").text("邮箱不合法~");
						return false;
					}
					var code = $("#code");
					$("span.errorMsg").text("");
				});
			});
		</script>
	</head>
	<body>
		<div id="login_header">
			<img class="logo_img" alt="" src="static/img/logo.gif" >
		</div>
		
			<div class="login_banner">
			
				<div id="l_content">
					<span class="login_word">欢迎注册</span>
				</div>
				
				<div id="content">
					<div class="login_form">
						<div class="login_box">
							<div class="tit">
								<h1>注册尚硅谷会员</h1>
								<span class="errorMsg">${ requestScope.msg }</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" value="${ requestScope.user.username }" placeholder="请输入用户名" autocomplete="off" tabindex="1" name="username" id="username" />
									<br />
									<br />
									<label>用户密码：</label>
									<input class="itxt" type="password" placeholder="请输入密码" autocomplete="off" tabindex="1" name="password" id="password" />
									<br />
									<br />
									<label>确认密码：</label>
									<input class="itxt" type="password" placeholder="确认密码" autocomplete="off" tabindex="1" name="repwd" id="repwd" />
									<br />
									<br />
									<label>电子邮件：</label>
									<input class="itxt" type="text" value="${ requestScope.user.email }" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" name="email" id="email" />
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" value="${ requestScope.code }" type="text" style="width: 150px;" id="code"/>
									<img alt="" src="static/img/code.bmp" style="float: right; margin-right: 40px">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		<%@include file="/pages/common/footer.jsp" %>
	</body>
</html>