<%@ page import = "com.crudjspjava.dao.UsuarioDAO"%>
<jsp:useBean id="u" class = "com.crudjspjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property = "*" name = "u"/>

<%

UsuarioDAO.deletarUsuario(u);

response.sendRedirect("viewusuarios.jsp");



%>