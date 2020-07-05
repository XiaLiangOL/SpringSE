<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<fm:form method="post" modelAttribute="vo.user" action="add"><br>
	用户编码：<fm:input path="usercode"/><br>
	用户名称：<fm:input path="username"/><br>
	用户密码：<fm:password path="userpassword"/><br>
	用户生日：<fm:input path="birthday" cssClass="Wdate" readonly="readonly" onclick="WdatePicker();"/><br>
	用户地址：<fm:input path="address"/><br>
	联系电话：<fm:input path="phone"/><br>
	用户角色：<fm:radiobutton path="userrole" value="1"/>系统管理员
	<fm:radiobutton path="userrole" value="2"/>经理
	<fm:radiobutton path="userrole" value="3"/>普通用户
	<br>
	<input type="submit" value="保存">
</fm:form>
</body>
</html>