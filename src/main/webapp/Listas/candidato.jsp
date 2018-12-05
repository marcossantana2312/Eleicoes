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

<title>${candidato.nome}</title>
</head>


<body class="text-center">

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="index.jsp">Inicio</a> <a
						class="nav-link" href="formlogin.jsp">Login</a> <a
						class="nav-link" href="/Cadastros/formcadastrousuario.jsp">Cadastro</a>
					<a class="nav-link" href="ListarEleicoesServlet">Eleições</a> <a
						class="nav-link" href="consultas.jsp">Consultas de dados</a>

				</nav>
			</div>
		</header>
		<div align="left">
			<h2>Nome candidato:</h2>
			<br>
			
			<h3><c:out value="${candidato.nome }"></c:out>
			</h3><br>
		<h3>Proposta:</h3>
		<h4><c:out value="${candidato.proposta }"></c:out></h4>
		
		<h3>Chapa:</h3>
		<h4><c:out value="${candidato.chapa}"></c:out></h4>
		
		<h3>Número:</h3>
		<h4><c:out value="${candidato.numero}"></c:out></h4>
		</div> 
		
		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>Página web por Marcos Santana e Pedro Henrique</p>
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