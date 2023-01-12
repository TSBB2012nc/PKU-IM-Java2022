<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh">
<head>
    <meta charset="UTF-8">
    <title>管理员登录</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- Bootstrap 的 CSS 文件 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" crossorigin="anonymous">
    <!--    Bootstrap的图标库-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <!-- 选项 1：包含 Popper 的 Bootstrap 集成包 -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
</head>
<body>
<%--表单,action是提交的地址,method是数据传输方式 --%>
    <form action="doLogin.jsp" method="post" id="myForm">
        <h3 class="text-center">欢迎使用虚空新闻管理</h3>
        <div class="form-group">
            <input name="username" type="text" id="id_username" class="form-control" placeholder="请输入您的账号">
        </div>
        <div class="form-group">
            <input name="password" type="password" id="id_password" class="form-control" placeholder="请输入您的密码">
        </div>
        <div class="btn-group">
            <button type="submit" class="btn btn-primary">登录</button>
            <button type="button" class="btn btn-danger" onclick='location=href="regiest.jsp"'>没有账号?</button>
        </div>
    </form>
<script>
//给表单添加一个提交事件(可以尝试导入第三方插件:jQuery Validation),进行一个表单验证
    $("#myForm").submit(()=>{
    	if($("#id_username").val().length==0){
    		alert("用户名不能为空")
    		return false
    	}
    	if($("#id_password").val().length==0){
    		alert("密码不能为空")
    		return false
    	}
    	return true
    })
</script>

</body>
</html>