package br.ucsal.eleicoes.controller.lista.usuario;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.CandidatoDAO;
import br.ucsal.eleicoes.model.Candidato;

/**
 * Servlet implementation class ListarCandidatosUsuarioServlet
 */
public class ListarCandidatosUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id_Cargo = Long.parseLong(request.getParameter("id_Cargo"));
		CandidatoDAO dao = new CandidatoDAO();
		List<Candidato> candidatos = dao.listar(id_Cargo);
		request.setAttribute("candidatos", candidatos);
		RequestDispatcher rd = request.getRequestDispatcher("/ListasUsuario/listacandidatos.jsp");
		rd.forward(request, response);
	}
}
