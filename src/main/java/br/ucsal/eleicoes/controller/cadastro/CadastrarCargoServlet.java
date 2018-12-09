package br.ucsal.eleicoes.controller.cadastro;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CargoDAO;
import br.ucsal.eleicoes.model.Cargo;
import br.ucsal.eleicoes.model.Eleicao;

/**
 * Servlet implementation class CadastrarCargoServlet
 */
public class CadastrarCargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
//		System.out.println(request.getParameter("idEleicao1"));
//		System.out.println(request.getParameter("idEleicao2"));
		String idEleicao = request.getParameter("idEleicao1");
		if(!isLong(idEleicao)) {
			System.out.println("EMTREI AQUI");
			idEleicao = request.getParameter("idEleicao2");
		}
		String nome = request.getParameter("nome");
		String funcao = request.getParameter("funcao");
		Long id_Eleicao = Long.parseLong(idEleicao);
		Long cadastrarMais = Long.parseLong(request.getParameter("cadastro"));

		Cargo cargo = new Cargo();
		cargo.setNome(nome);
		cargo.setFuncao(funcao);
		cargo.setId_Eleicao(id_Eleicao);

		CargoDAO dao = new CargoDAO();
		dao.adicionar(cargo);
		if (cadastrarMais == 0) {
			cargo.setId_Cargo(dao.getId(cargo));
			request.setAttribute("cargo", cargo);
			RequestDispatcher rd = request.getRequestDispatcher("/Cadastros/formcadastrocandidato.jsp");
			rd.forward(request, response);
		} else {
			Eleicao eleicao = new Eleicao();
			eleicao.setId_Eleicao(id_Eleicao);
			request.setAttribute("eleicao", eleicao);
			RequestDispatcher rd = request.getRequestDispatcher("/Cadastros/formcadastrocargo.jsp");
			rd.forward(request, response);
		}
	}
	
	public boolean isLong(String idEleicao) {
		try {
			Long.parseLong(idEleicao);
		} catch (Exception e) {
	
			return false;
		}
		return true;
	}
}
