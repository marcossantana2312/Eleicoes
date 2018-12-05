<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@page import="br.ucsal.eleicoes.model.Usuario" %>
<%@page import="br.ucsal.eleicoes.model.Eleicao" %>
<%@page import="br.ucsal.eleicoes.model.Cargo" %>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/Cadastro.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">


<title>Cadastro Cargo</title>
</head>
<body>

	<% Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario == null ){
			response.sendRedirect(""+request.getContextPath()+"/formlogin.jsp");
		}else{
						
		}
	%>
		<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="/<% request.getContextPath();%>iniciousuario.jsp">Inicio</a> <a
						class="nav-link" href="/<% request.getContextPath();%>deslogar.jsp">Logout</a>
						 <a class="nav-link active" href="#">Cadastro</a>
						 <a	class="nav-link" href="/<% request.getContextPath();%>consultas.jsp">Consultas de dados</a>
				</nav>
			</div>
		</header>
			 <img class="mb-4" src="Resources/Images/Icon E.png" alt="" width="130" height="90">
		<H3>Cadastrar Candidato</H3>
		<form class="form-cadastro" action="<%request.getContextPath();%>/CadastrarCandidatoServlet"
			method="post">
			Nome:<br> <input class="form-control" type="text" name="nome" placeholder="Nome" required><br>
			Proposta:<br> <input class="form-control" type="text" name="proposta" placeholder="Proposta" required><br>
			Chapa:<br> <input class="form-control" type="text" name="chapa" placeholder="Chapa" required><br>
			Número:<br> <input class="form-control" type="text" name="numero" placeholder="30" required><br>
			<input type="hidden" value="${cargo.id_Eleicao}" name="idEleicao"/>
			<input type="hidden" value="${cargo.id_Cargo}" name="idCargo"><br> 
			<button class="btn btn-lg btn-secondary" type="submit" value="0" name="cadastro">Cadastrar Candidato</button>
			<button class="btn btn-lg btn-secondary" type="submit" value="1" name="cadastro">Cadastrar mais Candidatos</button>
		</form>


		<footer class="mastfoot mt-auto">
			<div class="inner">
				
			</div>
		</footer>
	</div>
	
	</body>
</html>
