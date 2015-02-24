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
Meus Repertorios
<table>
<c:forEach items="${repertoriosDoUsuario }" var="repertoriosDoUsuario">
<tr>
<td><a href="listarCantadasDoRepertorio?idRepertorio=${repertoriosDoUsuario.idRepertorio }"> ${repertoriosDoUsuario.nome }</a></td>
<td><a href="carregaRepertorioParaAtualizar?idRepertorio=${repertoriosDoUsuario.idRepertorio }">Editar informações</a></td>
<td><a href="excluirRepertorio?idRepertorio=${repertoriosDoUsuario.idRepertorio }">Excluir</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>