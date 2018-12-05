package br.ucsal.eleicoes.controller.lista;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.EleicaoDAO;
import br.ucsal.eleicoes.model.Eleicao;

/**
 * Servlet implementation class ListarEleicoesServlet
 */
public class ListarEleicoesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		EleicaoDAO dao = new EleicaoDAO();
		List<Eleicao> eleicoes = dao.listar();
		
		request.setAttribute("eleicoes", eleicoes);
		RequestDispatcher rd = request.getRequestDispatcher("/Listas/listareleicoes.jsp");
		rd.forward(request, response);
	}

	
}
