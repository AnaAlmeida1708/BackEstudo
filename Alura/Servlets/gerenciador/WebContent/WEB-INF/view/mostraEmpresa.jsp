<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<c:url value="/empresa" var="editarEmpresa"/>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Editar Empresa</title>
	</head>

	<body>
		<form action="${editarEmpresa } " method="post">
			<input type="text" hidden="true" name="id" value="${empresa.id }">
        	Nome: <input type="text" name="nome" value="${empresa.nome }"/>
        	Data abertura: <input type="text" name="dataAbertura" value="<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy "/>"/>
			<input type="hidden" name="acao" value="EditarEmpresa">
        	<input type="submit" />
    	</form>
	</body>
</html>
