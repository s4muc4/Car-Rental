package com.biblioteca.biblioteca.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.UniqueConstraint;

@Entity
public class Livro implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

	private String nome;
	private int edicao;
	private int qtde_paginas;
	private String categoria;
	
	@ManyToMany
	@JoinTable(
        name="AutorLivros", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_autor", "id_livro" }),
        joinColumns        = @JoinColumn(name = "id_livro"), 
        inverseJoinColumns = @JoinColumn(name = "id_autor")
	)
	private List<Autor> autores;
	
	@ManyToOne
	@JoinColumn(
		name="EditoraLivros"
	)
    private Editora editora;
 
	public Livro(String nome, int edicao, int qtde_paginas, String categoria) {
		this.nome = nome;
		this.edicao = edicao;
		this.qtde_paginas = qtde_paginas;
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Livro [categoria=" + categoria + ", edicao=" + edicao + ", nome=" + nome + ", qtde_paginas="
				+ qtde_paginas + "]";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getEdicao() {
		return edicao;
	}

	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}

	public int getQtde_paginas() {
		return qtde_paginas;
	}

	public void setQtde_paginas(int qtde_paginas) {
		this.qtde_paginas = qtde_paginas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public Livro() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Autor> getAutores() {
		return autores;
	}

	public void setAutores(List<Autor> autores) {
		this.autores = autores;
	}

	public Editora getEditora() {
		return editora;
	}

	public void setEditora(Editora editora) {
		this.editora = editora;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}