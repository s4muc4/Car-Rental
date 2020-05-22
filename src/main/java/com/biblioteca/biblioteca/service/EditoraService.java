package com.biblioteca.biblioteca.service;

import java.util.List;

import com.biblioteca.biblioteca.entity.Editora;
import com.biblioteca.biblioteca.repository.EditoraRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditoraService {

	@Autowired
    private EditoraRepository repository;
    
    public List<Editora> getEditoras(){
        return repository.findAll();
    }

    public void salvar(Editora editora){
        repository.save(editora);
    }

	public Editora getEditoraById(Integer id) {
		return repository.findById(id).get();
	}

	public void remover(Editora editora) {
        repository.delete(editora);
	}
	
	
}