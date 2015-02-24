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
Cantadas do Repertorio
<br>
<table>
<c:forEach items="${cantadasDoRepertorio }" var="cantadasDoRepertorio">
<tr>
<td>${cantadasDoRepertorio.textoDaCantada }</td>
<td><a href="carregarCantadaParaAtualizar?idCantada=${cantadasDoRepertorio.idCantada }">Editar</a></td>
<td><a href="excluirCantada?idCantada=${cantadasDoRepertorio.idCantada }">Excluir</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>