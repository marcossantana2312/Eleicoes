package br.ucsal.eleicoes.dao;
/**
 * CREATE TABLE IF NOT EXISTS eleicao(
	Id_Eleicao serial NOT NULL,	nome varchar(100) NOT NULL,	descricao varchar(255),	data_Votacao date, met_votacao varchar(255), Id_Usuario Integer NOT NULL);
ALTER TABLE eleicao ADD CONSTRAINT pk_idEleicao PRIMARY KEY(Id_Eleicao);
ALTER TABLE eleicao ADD CONSTRAINT fk_eleicaoUsuario FOREIGN KEY(email_Usuario) REFERENCES usuario(email);
 * @author Marcos
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.eleicoes.jdbc.ConnectionFactory;
import br.ucsal.eleicoes.model.Eleicao;

public class EleicaoDAO {
	Connection con;

	public EleicaoDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void adicionar(Eleicao eleicao) {
		String sql = "insert into eleicao (nome, descricao, email_usuario, data_votacao, met_votacao) values (?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, eleicao.getNome());
			stmt.setString(2, eleicao.getDescricao());
			stmt.setString(3, eleicao.getEmail_Usuario());
			stmt.setDate(4,java.sql.Date.valueOf(eleicao.getDataVotacao()));
			stmt.setString(5, eleicao.getMet_Votacao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Eleicao> listar() {
		List<Eleicao> eleicoes = new ArrayList<Eleicao>();
		String sql = "select * from eleicao";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Eleicao eleicao = new Eleicao();
				eleicao.setNome(rs.getString("nome"));
				eleicao.setDescricao(rs.getString("descricao"));
				String data = rs.getDate("data_votacao").toString();
				eleicao.setDataVotacao(LocalDate.parse(data));
				eleicao.setId_Eleicao(rs.getLong("id_eleicao"));
				eleicao.setEmail_Usuario(rs.getString("email_usuario"));
				eleicoes.add(eleicao);
			}
			rs.close();
			stmt.close();
			return eleicoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Eleicao eleicao) {
		String sql = "update eleicao set nome=?, descricao=?, data_votacao=? where id_eleicao=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, eleicao.getNome());
			stmt.setString(2, eleicao.getDescricao());
			stmt.setDate(3, java.sql.Date.valueOf(eleicao.getDataVotacao()));
			stmt.setLong(4, eleicao.getId_Eleicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}
	
	public void remover(Eleicao eleicao) {
		String sql = "delete from eleicao where id_eleicao=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, eleicao.getId_Eleicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Long getId_Eleicao(String nome) {
		String sql = "select id_Eleicao from eleicao where nome=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, nome);
			ResultSet rs = stmt.executeQuery();
			Long id_Eleicao=100L;
			while(rs.next()) {
				id_Eleicao = rs.getLong("id_eleicao");
			}
			rs.close();
			stmt.close();
			return id_Eleicao;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Eleicao> listar(String email) {
		List<Eleicao> eleicoes = new ArrayList<Eleicao>();
		String sql = "select * from eleicao where email_usuario=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Eleicao eleicao = new Eleicao();
				eleicao.setNome(rs.getString("nome"));
				eleicao.setDescricao(rs.getString("descricao"));
				String data = rs.getDate("data_votacao").toString();
				eleicao.setDataVotacao(LocalDate.parse(data));
				eleicao.setId_Eleicao(rs.getLong("id_eleicao"));
				eleicao.setEmail_Usuario(rs.getString("email_usuario"));
				eleicoes.add(eleicao);
			}
			rs.close();
			stmt.close();
			return eleicoes;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}


	}

}
