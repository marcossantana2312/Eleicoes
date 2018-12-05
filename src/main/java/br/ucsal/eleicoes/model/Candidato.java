package br.ucsal.eleicoes.model;

public class Candidato {

	private Long id_Candidato;
	private String nome;
	private Long numero;
	private String chapa;
	private String proposta;
	private Long id_Eleicao;
	private Long id_Cargo;
	
	public Long getId_Candidato() {
		return id_Candidato;
	}
	public void setId_Candidato(Long id_Candidato) {
		this.id_Candidato = id_Candidato;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getNumero() {
		return numero;
	}
	public void setNumero(Long numero) {
		this.numero = numero;
	}
	public String getChapa() {
		return chapa;
	}
	public void setChapa(String chapa) {
		this.chapa = chapa;
	}
	public String getProposta() {
		return proposta;
	}
	public void setProposta(String proposta) {
		this.proposta = proposta;
	}
	public Long getId_Eleicao() {
		return id_Eleicao;
	}
	public void setId_Eleicao(Long id_Eleicao) {
		this.id_Eleicao = id_Eleicao;
	}
	public Long getId_Cargo() {
		return id_Cargo;
	}
	public void setId_Cargo(Long id_Cargo) {
		this.id_Cargo = id_Cargo;
	}
}
