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
        name="LivroAutores", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro", "id_autor" }),
        joinColumns        = @JoinColumn(name = "id_livro" ),
        inverseJoinColumns = @JoinColumn(name = "id_autor")
    )
	private List<Autor> autores;
	
	@OneToMany
    @JoinTable(
        name="LivroEditoras", 
        uniqueConstraints = @UniqueConstraint(columnNames = { "id_livro", "id_editora" }),
        joinColumns        = @JoinColumn(name = "id_livro" ),
        inverseJoinColumns = @JoinColumn(name = "id_editora")
    )
    private List<Editora> editoras;

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

}