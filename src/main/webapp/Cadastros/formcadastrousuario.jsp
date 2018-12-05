<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/Cadastro.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">

<title>Cadastro de Usuario</title>
</head>
<body>

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="/<% request.getContextPath();%>index.jsp">Inicio</a> <a
						class="nav-link" href="/<% request.getContextPath();%>formlogin.jsp">Login</a>
						 <a class="nav-link active" href="/<% request.getContextPath();%>/Cadastros/formcadastrousuario.jsp">Cadastro</a>
						 <a	class="nav-link" href="/<% request.getContextPath();%>consultas.jsp">Consultas de dados</a>
				</nav>
			</div>
		</header>
			 <img class="mb-4" src="Resources/Images/Icon E.png" alt="" width="130" height="90">
		<H3>Cadastrar Usuario</H3>
		<form class="form-cadastro" action="<%request.getContextPath();%>/CadastrarUsuarioServlet"
			method="post">
			Email:<br> <input class="form-control" type="email" name="email" placeholder="email@example.com" required><br>
			Senha:<br> <input class="form-control" type="password" name="senha" placeholder="senha" required><br>
			Nome:<br> <input class="form-control" type="text" name="nome" placeholder="Nome"><br> 
			<button class="btn btn-lg btn-secondary" type="submit">Cadastrar</button>
		</form>


		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>Página web por Marcos Santana e Pedro Henrique</p>
			</div>
		</footer>
	</div>

</body>
</html>