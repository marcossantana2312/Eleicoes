<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="br.ucsal.eleicoes.model.Usuario" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/entrar.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">
<title>Login</title>
</head>
<body>
<% Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario != null ){
			response.sendRedirect("iniciousuario.jsp");
		}
	%>

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="index.jsp">Inicio</a> 
					<a class="nav-link active"	href="<% request.getContextPath();%>/formlogin.jsp">Login</a>
					<a class="nav-link"	href="<% request.getContextPath();%>/Cadastros/formcadastrousuario.jsp">Cadastro</a>
					 <a	class="nav-link" href="<% request.getContextPath();%>/consultas.jsp">Consultas de dados</a>
				</nav>
			</div>
		</header>
 <form class="form-signin" action="/LoginServlet" method="post">
      	 <img class="mb-4" src="Resources/Images/Icon E.png" alt="" width="130" height="90" align="bottom">
      <h1 class="h3 mb-3 font-weight-normal">Entre por favor</h1>
      <label for="inputEmail" class="sr-only">Endereço de Email</label>
      <input type="email" id="inputEmail" class="form-control" placeholder="Endereço de Email" required autofocus name="email">
      <label for="inputPassword" class="sr-only">Senha</label>
      <input type="password" id="inputPassword" class="form-control" placeholder="Senha" name="senha" required>
     
      <button class="btn btn-lg btn-secondary" type="submit">Entrar</button><br>
      Ainda não possui conta?<br>
      <a href="Cadastros/formcadastrousuario" class="btn btn-lg btn-secondary">Cadastre-se</a>
    </form>
   
			

	<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>Página web por Marcos Santana e Pedro Henrique</p>
			</div>
		</footer>
	</div>

	<script src="/Resources/js/jquery.min.js"></script>
	<script src="/Resources/js/vendor/popper.min.js"></script>
	<script src="/Resources/js/bootstrap.min.js"></script>
</body>
</html>