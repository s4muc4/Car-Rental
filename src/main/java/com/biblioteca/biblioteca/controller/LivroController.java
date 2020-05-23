package com.biblioteca.biblioteca.controller;

import java.util.List;

import com.biblioteca.biblioteca.entity.Autor;
import com.biblioteca.biblioteca.entity.Editora;
import com.biblioteca.biblioteca.entity.Livro;
import com.biblioteca.biblioteca.service.AutorService;
import com.biblioteca.biblioteca.service.EditoraService;
import com.biblioteca.biblioteca.service.LivroService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LivroController {
	
	@Autowired
    private LivroService livroService;

    @Autowired
    private EditoraService editoraService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/livros")
    public ModelAndView getLivros(){
        
        ModelAndView mv = new ModelAndView("livrosTemplate");
    
        mv.addObject("livro",  new Livro());
        mv.addObject("livros", livroService.getLivros());
        mv.addObject("editoras", editoraService.getEditoras());
       
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
        mv.addObject("editoras", editoraService.getEditoras());
        mv.addObject("autores", autorService.getAutores());
        
        

        return mv;
    }

    @GetMapping("/removerLivroAutor/{L}/{A}")
    public String removerAutorLivro(@PathVariable Integer L, @PathVariable Integer A)
    {
        
        Livro livro = livroService.getLivroById(L);
        Autor autor = autorService.getAutorById(A);

        livro.getAutores().remove(autor);
        livroService.salvar(livro);

        return "redirect:/editarLivro?id=" + L;
    }

    @GetMapping("/detalhesLivro")
    public ModelAndView getLivroDetalhes(@RequestParam Integer id) {
        
        Livro livro = livroService.getLivroById(id);
        ModelAndView mv = new ModelAndView("detalhesLivro");
		mv.addObject("livro", livro);
        
        List<Autor> autoresALL = autorService.getAutores();

        autoresALL.removeAll(livro.getAutores());

        mv.addObject("autoresNaoAssociados", autoresALL);
        

        return mv;
    }

    @PostMapping("/associarAutor")
    public String associar(@ModelAttribute Autor autor, @RequestParam Integer var)
    {
        Livro livro = livroService.getLivroById(var);
        
        autor = autorService.getAutorById(autor.getId());

        livro.getAutores().add(autor);
        livroService.salvar(livro);

        return "redirect:/detalhesLivro?id=" + var;
    }

    @PostMapping("/salvarLivro")
    public String salvar(@ModelAttribute Livro livro){
        livroService.salvar(livro);
        return "redirect:/livros";
    }
}