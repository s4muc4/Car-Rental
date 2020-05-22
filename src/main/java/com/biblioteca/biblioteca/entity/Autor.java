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
public class Autor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
	
	private String nome;
	private int idade;
	private String nacionalidade;
	private String ocupacao;
	
	/* @OneToMany
    @JoinTable(
        name="AutorLivros", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "codigo_autor", "id_livro" }),
        joinColumns        = @JoinColumn(name = "id_autor"), 
        inverseJoinColumns = @JoinColumn(name = "codigo_livro")
    )
    private List<Livro> livros; */
	

	public Autor(String nome, int idade, String nacionalidade, String ocupacao) {
		this.nome = nome;
		this.idade = idade;
		this.nacionalidade = nacionalidade;
		this.ocupacao = ocupacao;
	}

	@Override
	public String toString() {
		return "Autor [nacionalidade=" + nacionalidade + ", idade=" + idade + ", nome=" + nome + ", ocupacao="
				+ ocupacao + "]";
	}

	

	public Autor() {
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public String getOcupacao() {
		return ocupacao;
	}

	public void setOcupacao(String ocupacao) {
		this.ocupacao = ocupacao;
	}

}