package br.ucsal.eleicoes.controller.alterar;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CandidatoDAO;
import br.ucsal.eleicoes.model.Candidato;

/**
 * Servlet implementation class AlterarCandidatoServlet
 */
@WebServlet("/AlterarCandidatoServlet")
public class AlterarCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String nome = request.getParameter("nome");
		Long numero = Long.parseLong(request.getParameter("numero"));
		String proposta = request.getParameter("proposta");
		String chapa = request.getParameter("chapa");
		Long id_Candidato = Long.parseLong(request.getParameter("idCandidato"));

		Candidato candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setChapa(chapa);
		candidato.setNumero(numero);
		candidato.setProposta(proposta);
		candidato.setId_Candidato(id_Candidato);
		
		CandidatoDAO dao = new CandidatoDAO();
		dao.alterar(candidato);
		
		response.sendRedirect("/");
	}

}
