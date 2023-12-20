<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edicao do Usuario</title>
</head>
<body>

<%@page import="com.crudjspjava.bean.Usuario, com.crudjspjava.dao.UsuarioDAO" %>
<%
String id  = request.getParameter("id");
Usuario usuario = UsuarioDAO.getRegistroById(Integer.parseInt(id));

%>

</body>
</html>