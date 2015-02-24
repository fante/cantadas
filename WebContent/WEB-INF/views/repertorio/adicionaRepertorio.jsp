<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Criar Repertório</h2>
	<form action="adicionaRepertorio" method="post">
		<p>Nome: <input type="text" name="nome"></p>
		<label for="descricao">Descrição:</label><textarea rows="5" cols="25" name="descricao"></textarea><br>
		<input type="submit" value="Cadastrar">
	</form>
</body>
</html>