package br.ucsal.eleicoes.controller.cadastro;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.EleicaoDAO;
import br.ucsal.eleicoes.model.Eleicao;

/**
 * Servlet implementation class CadastrarEleicaoServlet
 */
public class CadastrarEleicaoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String descricao = request.getParameter("descricao");
		String email_Usuario = request.getParameter("email");
		LocalDate dataVotacao = LocalDate.parse(request.getParameter("dataVotacao"));
		String metodo = request.getParameter("metodo");
		Eleicao eleicao = new Eleicao();
		eleicao.setNome(nome);
		eleicao.setDescricao(descricao);
		eleicao.setDataVotacao(dataVotacao);
		eleicao.setEmail_Usuario(email_Usuario);
		eleicao.setMet_Votacao(metodo);
		EleicaoDAO dao = new EleicaoDAO();
		dao.adicionar(eleicao);
		eleicao.setId_Eleicao(dao.getId_Eleicao(nome));
		System.out.println(eleicao.getId_Eleicao());
		request.setAttribute("eleicao", eleicao);
		RequestDispatcher rd = request.getRequestDispatcher("/Cadastros/formcadastrocargo.jsp");
		rd.forward(request, response);
	}

}
