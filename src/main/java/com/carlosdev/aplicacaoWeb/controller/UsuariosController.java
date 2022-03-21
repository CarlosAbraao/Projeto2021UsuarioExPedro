package com.carlosdev.aplicacaoWeb.controller;


import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import com.carlosdev.aplicacaoWeb.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/listar")
    public ModelAndView listarUsuarios(){

        ModelAndView mv = new ModelAndView("usuariosListar");
        mv.addObject("titulo","Listagem de usuários");

        // CRIANDO UM LISTA DE USUÁRIOS DO BANCO

        List<Usuario> usuarioList = usuarioService.findAll();
        mv.addObject("lista_usuarios",usuarioList);

        return mv;

    }

    @GetMapping("/criar")
    public String criarUsuariosPagina(Usuario usuario){

        return "usuariosCriar";

    }

    @PostMapping("/criar")
    public String criarUsuarios( Usuario usuario){
                usuarioService.save(usuario);
        return "redirect:/usuarios/listar";

    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){
        Usuario usuario = usuarioService.findUsuarioById(id);
        usuarioService.delete(usuario);

        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editarPagina(@PathVariable(value = "id") Long id){
        ModelAndView mv = new ModelAndView("usuariosEditar");
        Usuario usuario = usuarioService.findUsuarioById(id);
        mv.addObject("usuario",usuario);

        return mv;
    }

    @PostMapping("/editar/{id}")
    public String editar( Usuario usuario){

        usuarioService.save(usuario);


        return "redirect:/usuarios/listar";
    }
}
