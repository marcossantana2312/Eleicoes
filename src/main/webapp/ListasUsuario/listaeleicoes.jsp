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

<title>Lista de Eleicões</title>
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
					<a class="nav-link" href="../iniciousuario.jsp">Inicio</a> <a class="nav-link"
						href="../deslogar.jsp">Logout</a> <a class="nav-link"
						href="../Cadastros/formcadastrousuario.jsp">Cadastro</a>
						<a	class="nav-link" href="/<% request.getContextPath();%>consultas.jsp">Consultas de dados</a>
					<a class="nav-link active" href="#">Eleicões</a>
				</nav>
			</div>
		</header>

		<h1>Eleições</h1>
		<p class="lead">Clique em uma eleição pra ter mais detalhes sobre
			ela</p>


		<div class="row">
			<c:forEach var="eleicao" items="${eleicoes}">
				<div class="col-4">${eleicao.nome}</div>
				<div class="col-4">${eleicao.descricao}</div>
				<div class="detalhe">
					<form action="ListarCargosUsuarioServlet">
						<input type="hidden" name="id_Eleicao"
							value="${eleicao.id_Eleicao}"> <input type="submit"
							value="Detalhes" class="btn btn-lg btn-secondary">
					</form>
				<div class="alterar">
				</div>
					<form action="<%request.getContextPath();%>/Alterar/formalterareleicao.jsp">
						<input type="hidden" name="id_Eleicao" value="${eleicao.id_Eleicao}">
						 <input type="submit"	value="Alterar" class="btn btn-lg btn-secondary">
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

	<script src="/Resources/js/jquery.min.js"></script>
	<script src="/Resources/js/vendor/popper.min.js"></script>
	<script src="/Resources/js/bootstrap.min.js"></script>
</body>