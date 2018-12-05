package br.ucsal.eleicoes.controller.alterar;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.EleicaoDAO;
import br.ucsal.eleicoes.model.Eleicao;

/**
 * Servlet implementation class AlterarEleicaoServlet
 */
public class AlterarEleicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		Long id_Eleicao = Long.parseLong(request.getParameter("id_Eleicao"));
		LocalDate dataVotacao = LocalDate.parse(request.getParameter("dataVotacao"));
		Eleicao eleicao = new Eleicao();
		eleicao.setNome(nome);
		eleicao.setDescricao(descricao);
		eleicao.setId_Eleicao(id_Eleicao);
		eleicao.setDataVotacao(dataVotacao);
		
		EleicaoDAO dao = new EleicaoDAO();
		dao.alterar(eleicao);
		
	}

}
