<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url value="/empresa" var="url"/>
<!DOCTYPE html>

<html>
	<head>
		<meta charset="UTF-8">
		<title>Cadastrar Empresa</title>
	</head>

	<body>
	
		<form action="${url }" method="post">

        	Nome: <input type="text" name="nome" />
        	Data abertura: <input type="text" name="dataAbertura" />
        	<input type="hidden" name="acao" value="CadastraEmpresa">

        	<input type="submit" />
    	</form>
	</body>
</html>
