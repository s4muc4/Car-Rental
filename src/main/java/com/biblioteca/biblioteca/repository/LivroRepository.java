package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entity.Livro;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository <Livro, Integer> {
	
}