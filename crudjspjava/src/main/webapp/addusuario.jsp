<%@ page import = "com.crudjspjava.dao.UsuarioDAO"%>
<jsp:useBean id = "u" class="com.crudjspjava.bean.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%

	int i = UsuarioDAO.salvarUsuario(u);

	if(i >0){
		response.sendRedirect("addusuario-sucess.jsp");
	}else {
		response.sendRedirect("addusuario-error.jsp");
	}

%>