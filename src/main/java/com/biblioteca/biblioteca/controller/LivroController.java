package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entity.Livro;
import com.biblioteca.biblioteca.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {
	
	@Autowired
    private LivroService livroService;

    /* @Autowired
    private LivroService livroService; */
    
    @GetMapping("/livros")
    public ModelAndView getLivros(){
        
        ModelAndView mv = new ModelAndView("livrosTemplate");
    
        mv.addObject("livro",  new Livro());
        mv.addObject("livros", livroService.getLivros());
        //mv.addObject("livros", livroService.getLivros());
        
        return mv;
    }

    @GetMapping("/removerLivro")
    public String removerAutor(@RequestParam Integer id){
        
        Livro livro = livroService.getLivroById(id);
        livroService.remover(livro);

        return "redirect:/livros";
    }

    @GetMapping("/editarLivro")
    public ModelAndView editarLivro(@RequestParam Integer id){
        
        ModelAndView mv = new ModelAndView("livroEdit");
    
        Livro livro = livroService.getLivroById(id); 
        mv.addObject("livro",  livro);
        //mv.addObject("livros", livroService.getLivros());

        return mv;
   
    }


    /*
        Salva ou atualiza um objeto.
        Se a matricula for igual a zerp, cria um novo aluno
        Se a matricula for diferente de zero e existir na tabela aluno, atualiza o aluno.
    */
    
    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro){
        livroService.salvar(livro);
        return "redirect:/livros";
    }
}