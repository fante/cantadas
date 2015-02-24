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
Lista de paqueras do ${usuarioLogado.email }<br>
<hr>
<c:forEach items="${paquerasDoUsuario}" var="paquerasDoUsuario">
<p>${paquerasDoUsuario.paquerado.email }<a href="excluirPaquera?idPaquera=${paquerasDoUsuario.idPaquera }">Excluir paquera</a><a href="mandarCantada">Mandar cantada</a></p>
</c:forEach>
</body>
</html>