package br.ucsal.eleicoes.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	static String url = "jdbc:postgresql://localhost:5432/Eleicoes";
	static String user = "postgres";
	static String password = "postgresql";
	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, password);
			con.createStatement().execute("CREATE TABLE IF NOT EXISTS usuario (\r\n" + 
					"	nome varchar(255) NOT NULL,\r\n" + 
					"	email varchar(255) NOT NULL,\r\n" + 
					"	senha varchar(20) NOT NULL);\r\n" + 
					"ALTER TABLE usuario ADD CONSTRAINT pk_emailUsuario PRIMARY KEY(email);\r\n" + 
					"\r\n" + 
					"CREATE TABLE IF NOT EXISTS eleicao(\r\n" + 
					"	Id_Eleicao serial NOT NULL,\r\n" + 
					"	nome varchar(100) NOT NULL,\r\n" + 
					"	descricao varchar(255),\r\n" + 
					"	data_Votacao date,\r\n" + 
					"	met_Votacao varchar(255),\r\n" + 
					"	email_Usuario varchar(255) NOT NULL);\r\n" + 
					"ALTER TABLE eleicao ADD CONSTRAINT pk_idEleicao PRIMARY KEY(Id_Eleicao);\r\n" + 
					"ALTER TABLE eleicao ADD CONSTRAINT fk_eleicaoUsuario FOREIGN KEY(email_Usuario) REFERENCES usuario(email);\r\n" + 
					"\r\n" + 
					"CREATE TABLE IF NOT EXISTS cargo(\r\n" + 
					"	Id_Cargo serial NOT NULL,\r\n" + 
					"	nome varchar(100) NOT NULL,\r\n" + 
					"	funcao varchar(255) NOT NULL,\r\n" + 
					"	Id_Eleicao Integer NOT NULL);\r\n" + 
					"ALTER TABLE cargo ADD CONSTRAINT pk_idCargo PRIMARY KEY(Id_Cargo);\r\n" + 
					"ALTER TABLE cargo ADD CONSTRAINT fk_cargoEleicao FOREIGN KEY(Id_Eleicao) REFERENCES eleicao(Id_Eleicao);\r\n" + 
					"\r\n" + 
					"CREATE TABLE IF NOT EXISTS candidato (\r\n" + 
					"	Id_Candidato serial NOT NULL,\r\n" + 
					"	nome varchar(100) NOT NULL,\r\n" + 
					"	proposta varchar(255) NOT NULL,\r\n" + 
					"	numero Integer,\r\n" + 
					"	chapa varchar(255),\r\n" + 
					"	Id_Cargo Integer NOT NULL,\r\n" + 
					"	Id_Eleicao Integer);\r\n" + 
					"ALTER TABLE candidato ADD CONSTRAINT pk_idCandidato PRIMARY KEY(Id_Candidato);\r\n" + 
					"ALTER TABLE candidato ADD CONSTRAINT fk_candidatoCargo FOREIGN KEY(Id_Cargo) REFERENCES cargo(Id_Cargo);\r\n" + 
					"ALTER TABLE candidato ADD CONSTRAINT fk_candidatoEleicao FOREIGN KEY(Id_Eleicao) REFERENCES eleicao(Id_Eleicao);");
			System.out.println("Conectado com sucesso");
		} catch (SQLException e) {
			System.out.println("Erro - Conexao " + e.getMessage());
		} catch (ClassNotFoundException e) {
			System.out.println("Erro - Driver " + e.getMessage());
		}
		return con;
	}

}
