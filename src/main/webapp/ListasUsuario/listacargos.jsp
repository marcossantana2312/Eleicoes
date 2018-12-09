<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<%@page import="br.ucsal.eleicoes.model.Usuario" %>
<%@page import="br.ucsal.eleicoes.model.Cargo" %>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet" href="/Resources/css/bootstrap.min.css">
<link rel="stylesheet" href="/Resources/css/paginas/listar.css" />
<link rel="icon" href="/Resources/Images/Icon E.png">

<title>Lista de Cargos</title>
</head>
<% Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario == null ){
			response.sendRedirect("/"+request.getContextPath()+"formlogin.jsp");
		}
	%>
<body class="text-center">
	

	<div class="cover-container d-flex w-100 h-100 p-3 mx-auto flex-column">
		<header class="masthead mb-auto">
			<div class="inner">
				<h3 class="masthead-brand">Eleições</h3>
				<nav class="nav nav-masthead justify-content-center">
					<a class="nav-link" href="../iniciousuario.jsp">Inicio</a><a
						class="nav-link" href="../deslogar.jsp">Logout</a>
					<a class="nav-link"	href="../Cadastros/formcadastrousuario.jsp">Cadastro</a>
					<a class="nav-link active" href="#">Eleicões</a>
					 <a	class="nav-link" href="../consultas.jsp">Consultas de dados</a>
				</nav>
			</div>
		</header>
		
		<h1>Cargos</h1>  <form action="../Cadastros/formcadastrocargo.jsp">
		<input type="hidden" value="<%out.print(request.getAttribute("idEleicao1")); %>" name="idEleicao">
		 <input type="submit" value="Adicionar Cargo" class="btn btn-lg btn-secondary" >
		</form>
      <p class="lead">Clique em Detalhes para ver os candidatos do cargo ou em Alterar para alterar ou remover o cargo</p>

      
      <div class="row">
      <c:forEach var="cargo" items="${cargos}">
        <div class="col-4">${cargo.nome}</div>
        <div class="col-4">${cargo.funcao}</div>
        <div class="Detalhe">
        <form action="ListarCandidatosUsuarioServlet">
        <input type="hidden" name="id_Cargo" value="${cargo.id_Cargo}">
         <input type="hidden" name="id_Eleicao" value="${cargo.id_Eleicao}">
        <input type="submit" value="Detalhes" class="btn btn-lg btn-secondary" >
        </form></div>
        <div class="Detalhe">
        <form action="alterarcargoservlet">
        <input type="hidden" name="id_Cargo" value="${cargo.id_Cargo}">
        <input type="submit" value="Alterar" class="btn btn-lg btn-secondary" >
        </form></div>
      </c:forEach>
      </div>


		

		<footer class="mastfoot mt-auto">
			<div class="inner">
				<p>
		</p>
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