package br.ucsal.eleicoes.dao;
/**
 * CREATE TABLE IF NOT EXISTS usuario (
	email varchar(255) NOT NULL, senha varchar(20) NOT NULL, nome varchar(255);
ALTER TABLE usuario ADD CONSTRAINT pk_emailUsuario PRIMARY KEY(email);
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
import br.ucsal.eleicoes.model.Usuario;

public class UsuarioDAO {

	private Connection con;

	public UsuarioDAO() {
		con = ConnectionFactory.getConnection();
	}

	public void inserir(Usuario usuario) {
		String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getNome());
			stmt.setString(2, usuario.getEmail());
			stmt.setString(3, usuario.getSenha());
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Usuario> listar() {
		try {
			List<Usuario> usuarios = new ArrayList<Usuario>();
			String sql = "select * from usuario";
			PreparedStatement stmt = this.con.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Usuario usuario = new Usuario();
				usuario.setNome(rs.getString("nome"));
				usuario.setEmail(rs.getString("email"));
				usuario.setSenha(rs.getString("senha"));
				usuarios.add(usuario);
			}
			rs.close();
			stmt.close();
			return usuarios;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterarSenha(Usuario usuario) {
		String sql = "update usuario set senha=?, nome=? where email=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getSenha());
			stmt.setString(3, usuario.getNome());
			stmt.setString(3, usuario.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void apagar(Usuario usuario) {
		String sql = "delete from usuario where email=?";
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, usuario.getEmail());
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	public Usuario login(String email, String senha) {
		String sql = "select nome from usuario where email=? and senha=?";
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setSenha(senha);
		try {
			PreparedStatement stmt = con.prepareStatement(sql);
			stmt.setString(1, email);
			stmt.setString(2, senha);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
			usuario.setNome(rs.getString("nome"));
			}
			rs.close();
			stmt.close();
			return usuario;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
