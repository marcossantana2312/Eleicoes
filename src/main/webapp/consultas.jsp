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
<link rel="stylesheet" href="/Resources/css/paginas/inicio.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">

<title>Consultas</title>
</head>

<body class="text-center">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="index.jsp">Inicio</a> <a
						class="nav-link" href="formlogin.jsp">Login</a> <a
						class="nav-link" href="/Cadastros/formcadastrousuario.jsp">Cadastro</a>
					<a class="nav-link" href="ListarEleicoesServlet">Eleições</a> <a
						class="nav-link active" href="consultas.jsp">Consultas de dados</a>

				</nav>
			</div>
		</header>

	<form action="ConsultaDadosServlet">
	Quantidade minima:
	<select name="qtd">
		<option value= "1">1</option>
		<option value= "2">2</option>
		<option value= "3">3</option>
		<option value= "4">4</option>
	</select>
	<input type="submit" class="btn-lg btn-secondary" name="consulta" value="Candidatos por cargo">
	</form>
	<form action="ConsultaDadosServlet">
	Quantidade minima:
	<select name="qtd">
		<option value= "1">1</option>
		<option value= "2">2</option>
		<option value= "3">3</option>
		<option value= "4">4</option>
	</select>
	<input type="submit" class="btn-lg btn-secondary" name="consulta" value="Cargos por eleição">
	</form>
	<form action="ConsultaDadosServlet">
	Quantidade minima:
	<select name="qtd">
		<option value= "1">1</option>
		<option value= "2">2</option>
		<option value= "3">3</option>
		<option value= "4">4</option>
	</select>
	<input type="submit" class="btn-lg btn-secondary" name="consulta" value="Eleições por usuario">
	</form>
	

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
</html>