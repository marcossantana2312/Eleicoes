<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="br.ucsal.eleicoes.model.Usuario"%>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/listar.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">

<title>Lista de Candidatos</title>
</head>
<%
	Usuario usuario = (Usuario) session.getAttribute("usuario");
	if (usuario == null) {
		response.sendRedirect("/"+request.getContextPath()+"formlogin.jsp");
	}
%>
<body class="text-center">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="/<% request.getContextPath();%>iniciousuario.jsp">Inicio</a> <a
						class="nav-link" href="/<% request.getContextPath();%>deslogar.jsp">Logout</a> <a class="nav-link"
						href="<%request.getContextPath();%>/Cadastros/formcadastrousuario.jsp">Cadastro</a>
					<a class="nav-link active" href="#">Eleicões</a> <a
						class="nav-link" href="/<% request.getContextPath();%>consultas.jsp">Consultas de dados</a>
				</nav>
			</div>
		</header>

		<h1>Candidatos</h1>
		<p class="lead">Clique em Detalhes para ver as informações do
			candidato ou em Alterar para alterar ou remover o candidato</p>


		<div class="row">
			<c:forEach var="candidato" items="${candidatos}">
				<div class="col-4">${candidato.nome}</div>
				<div class="col-4">${candidato.numero}</div>
				<div class="detalhes">
					<form action="CandidatoServlet">
						<input type="hidden" name="id_Candidato"
							value="${candidato.id_Candidato}"> <input type="submit"
							value="Detalhes" class="btn btn-lg btn-secondary">
					</form>
				</div>
				<div class="alterar">
					<form action="<%request.getContextPath();%>/Alterar/alterarcandidato.jsp">
						<input type="hidden" name="id_Candidato"
							value="${candidato.id_Candidato}"> <input type="submit"
							value="Alterar" class="btn btn-lg btn-secondary">
					</form>
				</div>
			</c:forEach>
		</div>




		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p></p>
			</div>
		</footer>
	</div>


	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src=="/Resources/js/jquery.min.js"><\/script>')
	</script>
	<script src="/Resources/js/jquery.min.js"></script>
	<script src="/Resources/js/vendor/popper.min.js"></script>
	<script src="/Resources/js/bootstrap.min.js"></script>
</body>
</html>