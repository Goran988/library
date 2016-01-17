<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Dis be home madafaka</h2>
	<a href="${pageContext.request.contextPath}/register">Register</a>
	<c:if test="${message != null }">
	<h3><c:out value="${message}"/></h3>
	</c:if>
	<c:forEach items="${users}" var="user">
	<a href="<spring:url value="/user?username=${user.username}"/>">${user.username}</a>
	${user.password}
	<br/>
	</c:forEach>
</body>
</html>