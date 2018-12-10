package br.ucsal.eleicoes.controller.excluir;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CargoDAO;
import br.ucsal.eleicoes.model.Cargo;

/**
 * Servlet implementation class
 * ExcluirCargoServlet @WebServlet("/ExcluirCargoServlet")
 */
public class ExcluirCargoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Long id_Cargo = Long.parseLong(request.getParameter("idCargo"));

		Cargo cargo = new Cargo();
		cargo.setId_Cargo(id_Cargo);

		CargoDAO dao = new CargoDAO();
		dao.excluir(cargo);

		response.sendRedirect("/");
	}

}
