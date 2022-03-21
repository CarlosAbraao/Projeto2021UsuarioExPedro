package com.carlosdev.aplicacaoWeb.controller;


import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class InicialController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public String PaginaInicial(){

        Usuario usuario = new Usuario();

        usuario.setNome("Carlos Abraao");
        usuario.setIdade(37);

        usuarioRepository.save(usuario);

        return "paginaInicial";
    }
}
