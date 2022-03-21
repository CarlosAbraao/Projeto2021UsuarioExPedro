package com.carlosdev.aplicacaoWeb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {


    @GetMapping("/listar")
    public String listarUsuarios(){

        return "usuariosListar";

    }

    @GetMapping("/criar")
    public String criarUsuarios(){

        return "usuariosCriar";

    }
}
