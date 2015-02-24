<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Alterar dados de ${usuarioLogado.email }
	<br>
	<input type="text" disabled="disabled" name="emailAtual"
		value="${usuarioLogado.email}">
	<br>
	<hr>
	<br>
	<form action="atualizarDadosDoUsuario" method="post">
		<input type="hidden" name="idUsuario" value="${usuarioLogado.idUsuario }"><br>
		<input type="text" name="email"><br>
		<input type="password" name="senha"><br>
		<input type="submit" value="Cadastrar" />
	</form>
</body>
</html>