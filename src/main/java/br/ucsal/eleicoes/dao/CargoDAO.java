package br.ucsal.eleicoes.dao;
/**
 * CREATE TABLE IF NOT EXISTS cargo(
	Id_Cargo serial NOT NULL,	nome varchar(100) NOT NULL,	funcao varchar(255) NOT NULL, Id_Eleicao Integer NOT NULL);
ALTER TABLE cargo ADD CONSTRAINT pk_idCargo PRIMARY KEY(Id_Cargo);
ALTER TABLE cargo ADD CONSTRAINT fk_cargoEleicao FOREIGN KEY(Id_Eleicao) REFERENCES eleicao(Id_Eleicao);
 * @author Marcos
 *
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.eleicoes.jdbc.ConnectionFactory;
import br.ucsal.eleicoes.model.Cargo;

public class CargoDAO {
	Connection con;

	public CargoDAO() {
		con = ConnectionFactory.getConnection();

	}

	public void adicionar(Cargo cargo) {
		String sql = "insert into cargo (nome, funcao, id_eleicao) values (?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cargo.getNome());
			stmt.setString(2, cargo.getFuncao());
			stmt.setLong(3, cargo.getId_Eleicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			// TODO AackTrace();
			throw new RuntimeException(e);
		}

	}

	public List<Cargo> listar(Long id_Eleicao) {
		List<Cargo> cargos = new ArrayList<>();
		String sql = "Select * from cargo where id_eleicao=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id_Eleicao);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Cargo cargo = new Cargo();
				cargo.setNome(rs.getString("nome"));
				cargo.setFuncao(rs.getString("funcao"));
				cargo.setId_Eleicao(rs.getLong("id_eleicao"));
				cargo.setId_Cargo(rs.getLong("id_cargo"));
				cargos.add(cargo);
			}
			rs.close();
			stmt.close();
			return cargos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Cargo cargo) {
		String sql = "Update cargo set nome=?, funcao=? where id_cargo=?";
		try {
		PreparedStatement stmt = con.prepareStatement(sql);
		stmt.setString(1, cargo.getNome());
		stmt.setString(2, cargo.getFuncao());
		stmt.setLong(3, cargo.getId_Cargo());
		stmt.execute();
		stmt.close();
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void excluir(Cargo cargo) {
		String sql = "Delete cargo where id_cargo?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, cargo.getId_Cargo());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
	
	public Long getId(Cargo cargo) {
		String sql = "select id_cargo from cargo where nome=? and id_eleicao=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, cargo.getNome());
			stmt.setLong(2, cargo.getId_Eleicao());
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				cargo.setId_Cargo(rs.getLong("id_cargo"));
			}
			rs.close();
			stmt.close();
			return cargo.getId_Cargo();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
	}
}
