package br.ucsal.eleicoes.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.ucsal.eleicoes.dao.UsuarioDAO;
import br.ucsal.eleicoes.model.Usuario;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");
		String senha = request.getParameter("senha");
		UsuarioDAO dao = new UsuarioDAO();
		Usuario usuario = dao.login(email, senha);
		if (usuario.getNome() != null && usuario.getEmail() != null && usuario.getSenha()!=null) {
			
			HttpSession session = request.getSession();
			session.setAttribute("usuario", usuario);
			response.sendRedirect("iniciousuario.jsp");

		}else {
			System.out.println("DEU RUIM");
			String erro="Usuario invalido";
			response.sendRedirect("formlogin.jsp?erro="+erro);
		}
		
	}

}
