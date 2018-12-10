package br.ucsal.eleicoes.controller.alterar;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CargoDAO;
import br.ucsal.eleicoes.model.Cargo;

/**
 * Servlet implementation class AlterarCargoServlet
 */
@WebServlet("/AlterarCargoServlet")
public class AlterarCargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
		String funcao = request.getParameter("funcao");
		Long id_Cargo = Long.parseLong(request.getParameter("idCargo"));
		
		Cargo cargo = new Cargo();
		cargo.setNome(nome);
		cargo.setFuncao(funcao);
		cargo.setId_Cargo(id_Cargo);
		
		CargoDAO dao = new CargoDAO();
		dao.alterar(cargo);
		response.sendRedirect("/");
	}

}
