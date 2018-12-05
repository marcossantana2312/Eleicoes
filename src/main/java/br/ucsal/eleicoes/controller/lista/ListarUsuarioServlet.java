package br.ucsal.eleicoes.controller.lista;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.UsuarioDAO;
import br.ucsal.eleicoes.model.Usuario;

@WebServlet("/ListarUsuarioServlet")
public class ListarUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UsuarioDAO dao = new UsuarioDAO();
		List<Usuario> usuarios = dao.listar();
		request.setAttribute("usuarios", usuarios);
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/listausuario.jsp");
		rd.forward(request, response);
	}

}
