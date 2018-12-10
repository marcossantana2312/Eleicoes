package br.ucsal.eleicoes.controller.excluir;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CandidatoDAO;
import br.ucsal.eleicoes.model.Candidato;

/**
 * Servlet implementation class ExcluirCandidatoServlet
 */
@WebServlet("/ExcluirCandidatoServlet")
public class ExcluirCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id_Candidato = Long.parseLong(request.getParameter("idCandidato"));
		
		Candidato candidato = new Candidato();
		candidato.setId_Candidato(id_Candidato);
		
		CandidatoDAO dao = new CandidatoDAO();
		dao.excluir(candidato);
		
		response.sendRedirect("/");
	}

}
