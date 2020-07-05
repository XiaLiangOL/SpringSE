<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="fm"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
 <%@ taglib uri="http://itcast.cn/common/" prefix="ly" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body>

	<table border="1">
	<c:forEach items="${page.rows}" var="user">
			<tr>				
				<!-- new&nbsp;Date().Format(<span class="string">"yyyy-MM-dd");！ -->
				<td>${user.id}</td>
				<td>${user.address}</td>
				<td><fmt:formatDate pattern="yyyy-mm-dd" value="${user.birthday}"/></td>
				<td>${user.createdby}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.creationdate}" /></td>
				<td>${user.gender}</td>
				<td>${user.modifyby}</td>
				<td><fmt:formatDate pattern="yyyy-MM-dd" value="${user.modifydate }" /></td>
				<td>${user.phone }</td>
				<td>${user.usercode }</td>
				<td>${user.username }</td>
				<td>${user.userpassword }</td>
				<td>${user.userrole }</td>
			</tr>
		</c:forEach>
	</table>
	<ly:page url="${pageContext.request.contextPath }/userDetails" />
</body>
</html>