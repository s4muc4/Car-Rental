package com.biblioteca.biblioteca.controller;

import com.biblioteca.biblioteca.entity.Editora;
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
public class EditoraController {
	
	@Autowired
    private EditoraService editoraService;

	@Autowired
    private LivroService livroService; 
    
    @GetMapping("/editoras")
    public ModelAndView getEditoras(){
        
        ModelAndView mv = new ModelAndView("editorasTemplate");
    
        mv.addObject("editora",  new Editora());
        mv.addObject("editoras", editoraService.getEditoras());
        mv.addObject("livros", livroService.getLivros());
        
        return mv;
    }

    @GetMapping("/removerEditora")
    public String removerAutor(@RequestParam Integer id){
        
        Editora editora = editoraService.getEditoraById(id);
        editoraService.remover(editora);

        return "redirect:/editoras";
    }

    @GetMapping("/editarEditora")
    public ModelAndView editarEditora(@RequestParam Integer id){
        
        ModelAndView mv = new ModelAndView("editoraEdit");
    
        Editora editora = editoraService.getEditoraById(id); 
        mv.addObject("editora",  editora);
        mv.addObject("livros", livroService.getLivros());

        return mv;
   
	}
	
	@GetMapping("/detalhesEditora")
    public ModelAndView getEditoraDetalhes(@RequestParam Integer id) {
        
        Editora editora = editoraService.getEditoraById(id);
        ModelAndView mv = new ModelAndView("detalhesEditora");
		mv.addObject("editora", editora);
		mv.addObject("livros", livroService.getLivros());

        return mv;
    }


  
    
    @PostMapping("/salvarEditora")
    public String salvar(@ModelAttribute Editora editora){
        editoraService.salvar(editora);
        return "redirect:/editoras";
    }
	
}