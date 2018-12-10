package br.ucsal.eleicoes.controller.excluir;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.EleicaoDAO;
import br.ucsal.eleicoes.model.Eleicao;

/**
 * Servlet implementation class ExcluirEleicaoServlet
 */
public class ExcluirEleicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id_Eleicao = Long.parseLong(request.getParameter("id_Eleicao"));
		
		Eleicao eleicao = new Eleicao();
		eleicao.setId_Eleicao(id_Eleicao);
		
		EleicaoDAO dao = new EleicaoDAO();
		dao.remover(eleicao);
		
		response.sendRedirect("/");
	}

}
