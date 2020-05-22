package com.biblioteca.biblioteca.repository;

import com.biblioteca.biblioteca.entity.Editora;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EditoraRepository extends JpaRepository<Editora, Integer> {
	
}