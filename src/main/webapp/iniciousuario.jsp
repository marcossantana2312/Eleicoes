<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%@page import="br.ucsal.eleicoes.model.Usuario" %>
<html>
<head>
<meta charset="utf-8"/>

<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/inicio.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">

<title>Eleições</title>
</head>

  <body class="text-center">
  
  <% Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario == null ){
			response.sendRedirect("formlogin.jsp");
		}
	%>

    <div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
      <header class="masthead mb-auto">
        <div class="inner">
          <h3 class="masthead-brand">Eleições</h3>
          <nav class="nav nav-masthead justify-content-center">
            <nav class="nav nav-masthead justify-content-center">
					<a class="nav-link active" href="iniciousuario.jsp">Inicio</a> 
					<a class="nav-link"	href="deslogar.jsp">Logout</a>
					<a class="nav-link"	href="ListarEleicoesServlet">Eleições</a>
					 <a	class="nav-link" href="consultas.jsp">Consultas de dados</a>
				</nav>
          </nav>
        </div>
      </header>

      <main role="main" class="inner cover">
      	 <img class="mb-4" src="Resources/Images/Icon E.png" alt="" width="130" height="90">
        <h1 class="cover-heading">Projeto Eleições</h1>
        <p class="lead">Crie eleições de modo a facilitar a divulgação de dados...</p>
        <p class="lead">
          <a href="/Cadastros/formcadastroeleicao.jsp" class="btn btn-lg btn-secondary">Criar eleição</a>
          <a href="ListarEleicoesServlet" class="btn btn-lg btn-secondary">Eleições já criadas</a>
          <form action="ListarEleicoesUsuario" method="post">
          <input type="submit" class="btn btn-lg btn-secondary" value="Criadas por mim" method="post">
        	</form>
        </p>
      </main>

 
      <footer class="mastfoot mt-auto">
        <div class="inner">
          <p>Página web por Marcos Santana e Pedro Henrique</p>
        </div>
      </footer>
    </div>



  
  	<script src="/Resources/js/jquery.min.js"></script>
	<script src="/Resources/js/vendor/popper.min.js"></script>
	<script src="/Resources/js/bootstrap.min.js"></script>
</html>