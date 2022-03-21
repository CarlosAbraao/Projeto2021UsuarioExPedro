package com.carlosdev.aplicacaoWeb.controller;


import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/listar")
    public ModelAndView listarUsuarios(){

        ModelAndView mv = new ModelAndView("usuariosListar");
        mv.addObject("titulo","Listagem de usuários");

        // CRIANDO UM LISTA DE USUÁRIOS DO BANCO

        List<Usuario> usuarioList = usuarioRepository.findAll();
        mv.addObject("lista_usuarios",usuarioList);

        return mv;

    }

    @GetMapping("/criar")
    public String criarUsuariosPagina(Usuario usuario){

        return "usuariosCriar";

    }

    @PostMapping("/criar")
    public String criarUsuarios( Usuario usuario){
                usuarioRepository.save(usuario);
        return "redirect:/usuarios/listar";

    }

    @GetMapping("/deletar/{id}")
    public String deletar(@PathVariable(value = "id") Long id){
        Usuario usuario = usuarioRepository.findUsuarioById(id);
        usuarioRepository.delete(usuario);

        return "redirect:/usuarios/listar";
    }

    @GetMapping("/editar/{id}")
    public ModelAndView editar(@PathVariable(value = "id") Long id){
        ModelAndView mv = new ModelAndView("usuariosEditar");
        Usuario usuario = usuarioRepository.findUsuarioById(id);
        mv.addObject("usuario",usuario);

        return mv;
    }
}
