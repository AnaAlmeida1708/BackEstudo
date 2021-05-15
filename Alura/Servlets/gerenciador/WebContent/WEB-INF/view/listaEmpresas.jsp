<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
	<c:url value="/empresa?acao=RemoveEmpresa&id=" var="deletarEmpresa"/>
	<c:url value="/empresa?acao=MostraEmpresa&id=" var="mostraEmpresa"/>
	<head>
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
		<meta charset="UTF-8">
		<title>Lista Empresas</title>
	</head>
	
	<body>
		<input type="hidden" name="acao" value="ListaEmpresas">
		<c:if test="${not empty empresa }">
			Nova empresa ${empresa} cadastrada com sucesso!
		</c:if>
		<h1>Lista Empresas</h1>
			<table class="table" >
				  <thead class="thead-dark">
				    <tr>
				      <th scope="col">Nome empresa</th>
				      <th scope="col">Data abertura</th>
				      <th scope="col">Editar</th>
				      <th scope="col">Remover</th>
				    </tr>
				  </thead>
				  <tbody>
				  <c:forEach items="${empresas }" var="empresa">
					    <tr >
					      <td>${empresa.nome } </td>
					      <td><fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy "/></td>
					      <td><a href="${mostraEmpresa }${empresa.id }">Editar</a></td>
					      <td><a href="${deletarEmpresa }${empresa.id }">Deletar</a></td>
					    </tr>
				    </c:forEach>
				</tbody>
					
			</table>
			
	</body>
	
</html>