<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	Repertório para atualizar
	<br>

	<input type="text" disabled="disabled" name="dataCriacaoAtual"
		value="${repertorioEncontrado.nome}">
	<br>
	<input type="text" disabled="disabled" name="repertorioAtual"
		value="${repertorioEncontrado.descricao}">
	<br>
	<br>
	<hr>
	<br>
	<form action="atualizarRepertorio" method="post">
		<input type="hidden" name="idRepertorio" value="${repertorioEncontrado.idRepertorio }"><br>
		<input type="text" name="nome"><br>
		<input type="text" name="descricao"><br>
		<input type="submit" value="Cadastrar" />
	</form>

</body>
</html>