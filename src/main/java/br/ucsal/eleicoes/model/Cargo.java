package br.ucsal.eleicoes.model;

public class Cargo {
	
	private Long id_Cargo;
	private String nome;
	private String funcao;
	private Long id_Eleicao;
	
	public Long getId_Cargo() {
		return id_Cargo;
	}
	public void setId_Cargo(Long id_Cargo) {
		this.id_Cargo = id_Cargo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getFuncao() {
		return funcao;
	}
	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	public Long getId_Eleicao() {
		return id_Eleicao;
	}
	public void setId_Eleicao(Long id_Eleicao) {
		this.id_Eleicao = id_Eleicao;
	}
	
}
