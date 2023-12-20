<%@ page import = "com.crudjspjava.dao.UsuarioDAO"%>
<jsp:useBean id = "u" class = "com.crudjspjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<% int i = UsuarioDAO.updateUsuario(u); 
response.sendRedirect("viewusuarios.jsp");
%>
