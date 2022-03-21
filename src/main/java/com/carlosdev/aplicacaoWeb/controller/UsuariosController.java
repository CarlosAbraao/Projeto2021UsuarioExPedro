package com.carlosdev.aplicacaoWeb.controller;


import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
}
