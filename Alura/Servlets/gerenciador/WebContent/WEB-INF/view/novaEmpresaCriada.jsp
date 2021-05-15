<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Nova Empresa</title>
	</head>
	
	<body>
		<c:if test="${not empty empresa }">
			Nova empresa ${empresa} cadastrada com sucesso!
		</c:if>
		<c:if test="${empty empresa }">
			Nenhuma empresa cadastrada!
		</c:if>
		
	</body>
</html>