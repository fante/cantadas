<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Cantada para atualizar
<br>

<input type="text" disabled="disabled" name="textoDaCantadaAtual" value="${cantadaAtual.textoDaCantada }"><br>
<input type="text" disabled="disabled" name="dataCriacaoAtual" value="${cantadaAtual.dataCriacao }"><br>
<input type="text" disabled="disabled" name="repertorioAtual" value="${cantadaAtual.repertorio.nome }"><br>
<br><br><br><hr><br><br><br>

<table bgcolor="#f0f8ff">
		<form:form name="atualizaCantada" modelAttribute="cantadas" method="post"
			action="atualizaCantada">
			<tr>
				<td><input type="hidden" name="idCantada" value="${cantadaAtual.idCantada }"><br></td>
			</tr>
			<tr>
				<td><form:label path="textoDaCantada">Texto da Cantada:</form:label></td>
				<td><form:input path="textoDaCantada" /></td>
			</tr>
			<tr>
            <td><form:label path="repertorio">Repertórios do Usuário:</form:label></td>
            <td>
                <form:select path="repertorio">
                    <form:option value="0" label="--- Select ---"/>
                    <form:options items="${repertoriosDoUsuario}" itemValue="idRepertorio" itemLabel="nome"/>
                </form:select>
            </td>
        <tr/>
        <tr>
            <td><input type="submit" value="Cadastrar"/></td>
        </tr>
		</form:form>
	</table>OI

</body>
</html>