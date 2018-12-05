package br.ucsal.eleicoes.controller.lista.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CargoDAO;
import br.ucsal.eleicoes.model.Cargo;

/**
 * Servlet implementation class ListarCargosUsuarioServlet
 */
public class ListarCargosUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Long id_Eleicao = Long.parseLong(request.getParameter("id_Eleicao"));
		CargoDAO dao = new CargoDAO();
		List<Cargo> cargos = dao.listar(id_Eleicao);
		request.setAttribute("cargos", cargos);
		RequestDispatcher rd = request.getRequestDispatcher("/ListasUsuario/listacargos.jsp");
		rd.forward(request, response);
	}


}
