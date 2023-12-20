<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Visualizacao de Usuarios</title>
</head>
<body>
	<%@ page import="com.crudjspjava.dao.UsuarioDAO, com.crudjspjava.bean.*, java.util.*"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	
	<h1>Listagem de Usuario</h1>
	<%
	
	List<Usuario> list = UsuarioDAO.getAllUsuarios();
	request.setAttribute("list", list);
	
	%>
	
	<table border="1">
		<tr>
		<th>ID</th>
		<th>Nome</th>
		<th>Password</th>
		<th>Email</th>
		<th>Sexo</th>
		<th>Pais</th>
		<th>Editar</th>
		<th>Excluir</th>
		</tr>
		<c:forEach items="${list}" var = "usuario">
			<tr>
				<td>${usuario.getId()}</td>
				<td>${usuario.getNome()}</td>
				<td>${usuario.getPassword()}</td>
				<td>${usuario.getEmail()}</td>
				<td>${usuario.getSexo()}</td>
				<td>${usuario.getPais()}</td>
				<td><a href = "editForm.jsp?id=${usuario.getId()}">Editar</a> </td>
				<td><a href = "#">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
	<br>
	<a href = "#">Adicionar novo Usuario</a>


</body>
</html>