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
				//var username = this.value;
				var username = $("#username").val();
				var namePatt = /^\w{5,12}$/;
				if(!namePatt.test(username)){
					$("span.errorMsg").text("用户名不合法！");
					return;
				}
				$.getJSON("http://localhost:8080/book/userServlet","action=ajaxExistUsername&username=" + username,function(data){
					if(data.existsUsername){
						$("span.errorMsg").text("用户名【" + username + "】已被使用");
					}else{
						$("span.errorMsg").text("用户名可以使用");
					}
				});
			});
			
			$("img#codeImg").click(function(){
				this.src = "${ pageScope.basePath }kaptcha.jpg?a=" + new Date();
			});
			
			$("input#sub_btn").click(function(){
				
				//验证用户名
				var nameText = $("#username").val();
				var namePatt = /^\w{5,12}$/;
				if(nameText.length == 0){
					$("span.errorMsg").text("请输入用户名~~");
					return false;
				}else if(!namePatt.test(nameText)){
					$("span.errorMsg").text("用户名不合法！");
					return false;
				}
				
				//验证密码
				var passwordText = $("#password").val();
				var passwordPatt = /^\w{5,12}$/;
				if(passwordText.length == 0){
					$("span.errorMsg").text("请输入密码~~");
					return false;
				}else if(!passwordPatt.test(passwordText)){
				
					$("span.errorMsg").text("密码不合法！");
					return false;
				}
				
				//验证确认密码
				var repwdText = $("#repwd").val();
				if(repwdText.length == 0){
					$("span.errorMsg").text("请输入确认密码~~");
					return false;
				}else if(repwdText != passwordText){
					$("span.errorMsg").text("确认密码与密码不一致！");
					return false;
				}
				
				//验证邮箱
				var emailText = $("#email").val();
				var emailPatt = /^\w+([-+.]\w+)*@\w+([-.]\\w+)*\.\w+([-.]\w+)*$/;
				if(emailText.length == 0){
					$("span.errorMsg").text("请输入邮箱~~");
					return false;
				}else if(!emailPatt.test(emailText)){
					$("span.errorMsg").text("邮箱格式不正确！");
					return false;
				}
				
				//验证验证码
				var codeText = $("#code").val();
				codeText = $.trim(codeText);
				if(codeText == ""){
					$("span.errorMsg").text("验证码不能为空！");
					return false;
				}
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
								<span class="errorMsg">
									<%-- <%=request.getAttribute("msg")==null?"":request.getAttribute("msg") %> --%>
									${ requestScope.msg }
								</span>
							</div>
							<div class="form">
								<form action="userServlet" method="post">
									<input type="hidden" name="action" value="regist" />
									<label>用户名称：</label>
									<input class="itxt" type="text" placeholder="请输入用户名" autocomplete="off" tabindex="1" 
									name="username" id="username" value="${ requestScope.username }"/>
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
									<input class="itxt" type="text" placeholder="请输入邮箱地址" autocomplete="off" tabindex="1" 
									name="email" id="email" value="${ requestScope.email }"/>
									<br />
									<br />
									<label>验证码：</label>
									<input class="itxt" type="text" style="width: 100px;" name="code" id="code"
									value="${ requestScope.code }"/>
									<img alt="" id="codeImg" src="${ pageScope.path }kaptcha.jpg" style="float: right; margin-right: 40px;width: 110px; height: 40px;">									
									<br />
									<br />
									<input type="submit" value="注册" id="sub_btn" />
									
								</form>
							</div>
							
						</div>
					</div>
				</div>
			</div>
			
<%@ include file="/pages/common/footer.jsp" %>
</body>
</html>