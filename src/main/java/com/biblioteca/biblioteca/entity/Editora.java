package com.biblioteca.biblioteca.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.UniqueConstraint;

@Entity
public class Editora implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String nome;
	private String endereco;
	private String telefone;
	private String data_criacao;

	@OneToMany
    @JoinColumn(
        name="EditoraLivros"
    )
    private List<Livro> livros;

	public Editora(String nome, String endereco, String telefone, String data_criacao) {
		this.nome = nome;
		this.endereco = endereco;
		this.telefone = telefone;
		this.data_criacao = data_criacao;
	} 

	@Override
	public String toString() {
		return "Editora [data_criacao=" + data_criacao + ", endereco=" + endereco + ", nome=" + nome + ", telefone="
				+ telefone + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(String data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Editora() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}