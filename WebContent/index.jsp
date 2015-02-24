<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Login do sistema de cantadas</h2>
	<form action="efetuaLogin" method="post">
		<p>
			Login: <input type="text" name="email">
		</p>
		<p>
			Senha: <input type="password" name="senha">
		</p>
		<input type="submit" value="Entrar">
	</form>
	<br>
	<a href="formAdicionaUsuario">Cadastre-se</a>
	<br>
</body>
</html>