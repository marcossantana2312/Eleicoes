package br.ucsal.eleicoes.controller.cadastro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CandidatoDAO;
import br.ucsal.eleicoes.model.Candidato;
import br.ucsal.eleicoes.model.Cargo;

/**
 * Servlet implementation class CadastrarCandidatoServlet
 */
public class CadastrarCandidatoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		Long numero = Long.parseLong(request.getParameter("numero"));
		String proposta = request.getParameter("proposta");
		String chapa = request.getParameter("chapa");
		Long id_Eleicao = Long.parseLong(request.getParameter("idEleicao"));
		Long id_Cargo = Long.parseLong(request.getParameter("idCargo"));
		Long cadastrarMais = Long.parseLong(request.getParameter("cadastro"));

		Candidato candidato = new Candidato();
		candidato.setNome(nome);
		candidato.setChapa(chapa);
		candidato.setNumero(numero);
		candidato.setProposta(proposta);
		candidato.setId_Cargo(id_Cargo);
		candidato.setId_Eleicao(id_Eleicao);

		CandidatoDAO dao = new CandidatoDAO();
		dao.adicionar(candidato);
		System.out.println(candidato.getNome());
		if (cadastrarMais == 0) {
			response.sendRedirect("iniciousuario.jsp");
		} else {
			Cargo cargo = new Cargo();
			cargo.setId_Cargo(id_Cargo);
			cargo.setId_Eleicao(id_Eleicao);
			request.setAttribute("cargo", cargo);
			RequestDispatcher rd = request.getRequestDispatcher("/Cadastros/formcadastrocandidato.jsp");
			rd.forward(request, response);
		}
	}

}
