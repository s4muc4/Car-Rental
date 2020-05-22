package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entity.Autor;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository <Autor, Integer>{
	
}