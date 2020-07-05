<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://itcast.cn/common/" prefix="ly" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="modify" method="post">
请输入id=2的用户的新密码：<input type="text" name="pwd">
<input type="submit" value="提交">
<ly:page url="${pageContext.request.contextPath }/customer/list.action" />
</form>
</body>
</html>