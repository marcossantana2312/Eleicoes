package br.ucsal.eleicoes.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ucsal.eleicoes.dao.ConsultaDAO;
import br.ucsal.eleicoes.model.Consulta;

/**
 * Servlet implementation class ConsultaDadosServlet
 */
@WebServlet("/ConsultaDadosServlet")
public class ConsultaDadosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String consulta = request.getParameter("consulta");
		Long qtd = Long.parseLong(request.getParameter("qtd"));
		ConsultaDAO dao = new ConsultaDAO();
		List<Consulta> consultas;
		
		if(consulta.equals("Candidatos por cargo")) {
			consultas = dao.getCandidatoCargo(qtd);
		}else if(consulta.equals("Cargos por eleição")) {
			consultas = dao.getCargoEleicao(qtd);
		}else if(consulta.equals("Eleições por usuario")) {
			consultas = dao.getEleicaoUsuario(qtd);
		}
		else {
			consultas = null;
		}
		request.setAttribute("consultas", consultas);
		RequestDispatcher rd = request.getRequestDispatcher("exibirconsulta.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
