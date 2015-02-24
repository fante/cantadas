<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script type="text/javascript" src="resources/js/jquery.js"></script>
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
function aceitarPaquera(idPaquera) {
	$.post("aceitarPaquera",{'idPaquera':idPaquera},function(){
		$("#"+idPaquera).closest("p").hide();
	});
}

function rejeitarPaquera(idPaquera) {
	$.post("rejeitarPaquera",{'idPaquera':idPaquera},function(){
		$("#"+idPaquera).closest("p").hide();
	});
}
</script>
Oi usuário ${usuarioLogado.email}
<br><br>
<a href="formAdicionaRepertorio">Criar novo Repertório</a>
<br><br>
<a href="formAdicionaCantada">Criar nova Cantada</a>
<br><br>
<a href="listarRepertoriosDoUsuario">Exibir todos os Repertórios</a>
<br><br>
<a href="listarPaquerasDoUsuario">Exibir todas as minhas Paqueras</a>
<br><br>
<a href="formAlterarDadosDoUsuario">Alterar dados pessoais</a>
<br><br>
<a href="excluirConta?idUsuario=${usuarioLogado.idUsuario }">Excluir conta</a>
<br><hr><br>
Pessoas que talvez você queira paquerar
<br>
<c:forEach items="${usuariosPreferidos }" var="usuariosPreferidos">${usuariosPreferidos.email }<a href="formEnviarSolicitacaoDePaquera?idPaquerador=${usuarioLogado.idUsuario }&idPaquerado=${usuariosPreferidos.idUsuario }">TentarPaquerar</a><br>
</c:forEach>
<hr><br>
Solicitação de paqueras pendentes
<c:forEach items="${paquerasPendentes }" var="paquerasPendentes">
<%-- <br>${paquerasPendentes.paquerador.email}<a href="aceitarPaquera?idPaquera=${paquerasPendentes.idPaquera }">Aceitar Paquera</a><a href="rejeitarPaquera">Rejeitar Paquera</a><br> --%>
<p>${paquerasPendentes.paquerador.email}<a id="${paquerasPendentes.idPaquera }" href="#" onclick="aceitarPaquera(${paquerasPendentes.idPaquera})">Aceitar Paquera</a><a href="#" onclick="rejeitarPaquera(${paquerasPendentes.idPaquera})">Rejeitar Paquera</a></p>
</c:forEach>
</body>
</html>