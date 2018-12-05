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

<title>Consultas</title>
</head>

<body class="text-center">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="index.jsp">Inicio</a> <a class="nav-link"
						href="formlogin.jsp">Login</a> <a class="nav-link"
						href="/Cadastros/formcadastrousuario.jsp">Cadastro</a> <a
						class="nav-link" href="ListarEleicoesServlet">Eleições</a> <a
						class="nav-link active" href="consultas.jsp">Consultas de
						dados</a>

				</nav>
			</div>
		</header>


		<c:forEach var="consulta" items="${consultas}">
			<div class="row">
				<div class="col-4">${consulta.consulta}</div>
				<div class="col-4">${consulta.qtd}</div>
			</div>
		</c:forEach>

		<footer class="mastfoot mt-auto">
			<div class="inner"></div>
		</footer>
	</div>



	<script src="/Resources/js/jquery.min.js"></script>
	<script src="/Resources/js/vendor/popper.min.js"></script>
	<script src="/Resources/js/bootstrap.min.js"></script>
</body>
</html>