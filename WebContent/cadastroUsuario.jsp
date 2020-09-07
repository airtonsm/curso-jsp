<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro Usu�rio</title>
 <link rel="stylesheet" href="./resources/css/cadastro.css" />
</head>
<body>	

<h1>Cadastro de usu�rio</h1>

	<form action="salvarUsuario" method="post">	

		C�digo:
		<input type="text" readonly="readonly" id="id" name="id" value="${user.id}">
		<br/>
		Login:
		<input type="text" id="login" name="login" value="${user.login}">
		<br/>
		Senha:
		<input type="password" id="senha" name="senha" value="${user.senha }">
		<br/>
		<input type="submit" value="Salvar">		
	</form>

	<table>
	 <c:forEach items="${usuarios}" var="user">
		<tr>
			<td style = "width: 150px"><c:out value="${user.id }"></c:out></td>
			<td style = "width: 150px"><c:out value="${user.login }"></c:out></td>
			<td><c:out value="${user.senha }"></c:out></td>	

			<td><a href="salvarUsuario?acao=delete&user=${user.login}">Excluir</a></td>
			<td><a href="salvarUsuario?acao=editar&user=${user.login}">Editar</a></td>
		</tr>
	</c:forEach>	
	</table>


</body>
</html> 