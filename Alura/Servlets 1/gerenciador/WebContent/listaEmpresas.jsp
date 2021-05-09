<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Lista Empresas</title>
	</head>
	
	<body>
		<h1>Lista Empresas</h1>
		<ul>
			<c:forEach items="${empresas }" var="empresa">
			
				<li>${empresa.nome }   <fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy "/></li>
			</c:forEach>
		</ul>
	</body>
	
</html>