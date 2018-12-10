package br.ucsal.eleicoes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.ucsal.eleicoes.jdbc.ConnectionFactory;
import br.ucsal.eleicoes.model.Candidato;

/**
 * CREATE TABLE IF NOT EXISTS candidato ( Id_Candidato serial NOT NULL, nome
 * varchar(100) NOT NULL, proposta varchar(255) NOT NULL, numero Integer, chapa
 * varchar(255), Id_Cargo Integer NOT NULL, Id_Eleicao Integer); ALTER TABLE
 * candidato ADD CONSTRAINT pk_idCandidato PRIMARY KEY(Id_Candidato); ALTER
 * TABLE candidato ADD CONSTRAINT fk_candidatoCargo FOREIGN KEY(Id_Cargo)
 * REFERENCES cargo(Id_Cargo); ALTER TABLE candidato ADD CONSTRAINT
 * fk_candidatoEleicao FOREIGN KEY(Id_Eleicao) REFERENCES eleicao(Id_Eleicao);
 * 
 * @author Marcos
 *
 */
public class CandidatoDAO {
	Connection con;
	public CandidatoDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void adicionar(Candidato candidato) {
		String sql = "insert into candidato (nome, chapa, proposta, numero, id_cargo, id_eleicao) values (?,?,?,?,?,?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getChapa());
			stmt.setString(3, candidato.getProposta());
			stmt.setLong(4, candidato.getNumero());
			stmt.setLong(5, candidato.getId_Cargo());
			stmt.setLong(6, candidato.getId_Eleicao());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public List<Candidato> listar(Long id_Cargo) {
		List<Candidato> candidatos = new ArrayList<>();
		String sql = "Select * from candidato where id_cargo=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id_Cargo);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Candidato candidato = new Candidato();
				candidato.setNome(rs.getString("nome"));
				candidato.setChapa(rs.getString("chapa"));
				candidato.setProposta(rs.getString("proposta"));
				candidato.setNumero(rs.getLong("numero"));
				candidato.setId_Eleicao(rs.getLong("id_eleicao"));
				candidato.setId_Cargo(rs.getLong("id_cargo"));
				candidato.setId_Candidato(rs.getLong("id_candidato"));
				candidatos.add(candidato);
			}
			rs.close();
			stmt.close();
			return candidatos;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public void alterar(Candidato candidato) {
		String sql = "Update candidato set nome=?, chapa=?, proposta=?, numero=?  where id_candidato=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, candidato.getNome());
			stmt.setString(2, candidato.getChapa());
			stmt.setString(3,candidato.getProposta());
			stmt.setLong(4, candidato.getNumero());
			stmt.setLong(5, candidato.getId_Candidato());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void excluir(Candidato candidato) {
		String sql = "Delete from candidato where id_candidato=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, candidato.getId_Candidato());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

	public Candidato getCandidato(Long id_Candidato) {
		String sql = "select * from candidato where id_Candidato=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setLong(1, id_Candidato);
			Candidato candidato = new Candidato();
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				candidato.setNome(rs.getString("nome"));
				candidato.setChapa(rs.getString("chapa"));
				candidato.setProposta(rs.getString("proposta"));
				candidato.setNumero(rs.getLong("numero"));
				candidato.setId_Eleicao(rs.getLong("id_eleicao"));
				candidato.setId_Cargo(rs.getLong("id_cargo"));
				candidato.setId_Candidato(id_Candidato);
			}
			rs.close();
			stmt.close();
			return candidato;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
