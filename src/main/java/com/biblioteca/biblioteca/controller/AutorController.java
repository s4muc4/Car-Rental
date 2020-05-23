package com.biblioteca.biblioteca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.biblioteca.biblioteca.entity.Autor;
import com.biblioteca.biblioteca.entity.Livro;
import com.biblioteca.biblioteca.service.AutorService;
//import com.biblioteca.biblioteca.service.LivroService;
import com.biblioteca.biblioteca.service.LivroService;


@Controller
public class AutorController {

	@Autowired
    private AutorService autorService;

    @Autowired
    private LivroService livroService; 
    
    @GetMapping("/autores")
    public ModelAndView getAutores(){
        
        ModelAndView mv = new ModelAndView("autoresTemplate");
    
        mv.addObject("autor",  new Autor());
        mv.addObject("autores", autorService.getAutores());
        //mv.addObject("livros", livroService.getLivros());
        
        return mv;
    }

    @GetMapping("/removerAutor")
    public String removerAutor(@RequestParam Integer id){
        
        Autor autor = autorService.getAutorById(id);
        autorService.remover(autor);

        return "redirect:/autores";
    }

    @GetMapping("/editarAutor")
    public ModelAndView editarAutor(@RequestParam Integer id){
        
        ModelAndView mv = new ModelAndView("autorEdit");
    
        Autor autor = autorService.getAutorById(id); 
        mv.addObject("autor",  autor);
        //mv.addObject("livros", livroService.getLivros());

        return mv;
   
    }

    @GetMapping("/detalhesAutor")
    public ModelAndView getAutorDetalhes(@RequestParam Integer id) {
        
        Autor autor = autorService.getAutorById(id);
        ModelAndView mv = new ModelAndView("detalhesAutor");
		mv.addObject("autor", autor);
        
        List<Livro> livrosALL = livroService.getLivros();

        livrosALL.removeAll(autor.getLivros());

        mv.addObject("livrosNaoAssociados", livrosALL);

        System.out.println(mv.toString());
        
        System.out.println(autor.getLivros().toString());
        return mv;
    }


    /*
        Salva ou atualiza um objeto.
        Se a matricula for igual a zerp, cria um novo aluno
        Se a matricula for diferente de zero e existir na tabela aluno, atualiza o aluno.
    */
    
    @PostMapping("/salvarAutor")
    public String salvar(@ModelAttribute Autor autor){
        autorService.salvar(autor);
        return "redirect:/autores";
    }
}
	
	
