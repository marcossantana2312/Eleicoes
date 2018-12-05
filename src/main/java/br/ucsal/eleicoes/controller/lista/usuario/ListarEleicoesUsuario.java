package br.ucsal.eleicoes.controller.lista.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.eleicoes.dao.EleicaoDAO;
import br.ucsal.eleicoes.model.Eleicao;
import br.ucsal.eleicoes.model.Usuario;

/**
 * Servlet implementation class ListarEleicoesUsuario
 */
public class ListarEleicoesUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario)session.getAttribute("usuario");
		if(usuario == null) {
			response.sendRedirect("formlogin.jsp");
		}
		EleicaoDAO dao = new EleicaoDAO();
		List<Eleicao> eleicoes = dao.listar(usuario.getEmail());
		
		request.setAttribute("eleicoes", eleicoes);
		RequestDispatcher rd = request.getRequestDispatcher("ListasUsuario/listaeleicoes.jsp");
		rd.forward(request, response);
	}

}
