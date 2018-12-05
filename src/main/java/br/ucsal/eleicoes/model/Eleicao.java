package br.ucsal.eleicoes.model;

import java.time.LocalDate;

public class Eleicao {
	
	private Long id_Eleicao;
	private String nome;
	private String descricao;
	private LocalDate dataVotacao;
	private String email_Usuario;
	private String met_Votacao;
	
	public Long getId_Eleicao() {
		return id_Eleicao;
	}
	public void setId_Eleicao(Long id_Eleicao) {
		this.id_Eleicao = id_Eleicao;
	}
		public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public LocalDate getDataVotacao() {
		return dataVotacao;
	}
	public void setDataVotacao(LocalDate dataVotacao) {
		this.dataVotacao = dataVotacao;
	}
	public String getEmail_Usuario() {
		return email_Usuario;
	}
	public void setEmail_Usuario(String email_Usuario) {
		this.email_Usuario = email_Usuario;
	}
	public String getMet_Votacao() {
		return met_Votacao;
	}
	public void setMet_Votacao(String met_Votacao) {
		this.met_Votacao = met_Votacao;
	}
}
