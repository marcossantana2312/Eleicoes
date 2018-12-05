package br.ucsal.eleicoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.eleicoes.jdbc.ConnectionFactory;
import br.ucsal.eleicoes.model.Consulta;

public class ConsultaDAO {

	Connection con;

	public ConsultaDAO() {
		con = ConnectionFactory.getConnection();
	}

	public List<Consulta> getCandidatoCargo(Long qtd) {
		String sql = "select cr.nome, count(cr.id_cargo) as cont \r\n"
				+ "from cargo cr full outer join candidato c on c.id_cargo = cr.id_cargo group by cr.id_cargo having count(cr.id_cargo)>=?;";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, qtd);
			List<Consulta> consultas = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setConsulta(rs.getString("nome"));
				consulta.setQtd(rs.getLong("cont"));
				consultas.add(consulta);
			}
			rs.close();
			stmt.close();
			return consultas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Consulta> getCargoEleicao(Long qtd) {
		String sql = "select e.nome , count(e.id_eleicao) as cont\r\n" + 
				"from eleicao e full outer join cargo c on c.id_eleicao = e.id_eleicao group by e.id_eleicao having count(e.id_eleicao)>=?;";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, qtd);
			List<Consulta> consultas = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setConsulta(rs.getString("nome"));
				consulta.setQtd(rs.getLong("cont"));
				consultas.add(consulta);
			}
			rs.close();
			stmt.close();
			return consultas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public List<Consulta> getEleicaoUsuario(Long qtd) {
		String sql = "select u.email , count(u.email) as cont\r\n" + 
				"from usuario u full outer join eleicao e on e.email_usuario = u.email group by u.email having count(u.email)>=?;";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, qtd);
			List<Consulta> consultas = new ArrayList<>();
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Consulta consulta = new Consulta();
				consulta.setConsulta(rs.getString("email"));
				consulta.setQtd(rs.getLong("cont"));
				consultas.add(consulta);
			}
			rs.close();
			stmt.close();
			return consultas;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


}
