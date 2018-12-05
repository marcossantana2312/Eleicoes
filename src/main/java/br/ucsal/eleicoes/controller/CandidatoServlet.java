package br.ucsal.eleicoes.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CandidatoDAO;
import br.ucsal.eleicoes.model.Candidato;

/**
 * Servlet implementation class CandidatoServlet
 */
public class CandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id_Candidato = Long.parseLong(request.getParameter("id_Candidato"));
		CandidatoDAO dao = new CandidatoDAO();
		Candidato candidato = dao.getCandidato(id_Candidato);
		
		request.setAttribute("candidato", candidato);
		RequestDispatcher rd = request.getRequestDispatcher("/Listas/candidato.jsp");
		rd.forward(request, response);
	}

	

}
