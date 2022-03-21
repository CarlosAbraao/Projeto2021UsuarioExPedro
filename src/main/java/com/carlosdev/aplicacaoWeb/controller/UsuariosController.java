package com.carlosdev.aplicacaoWeb.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/usuarios")
public class UsuariosController {


    @GetMapping("/listar")
    public ModelAndView listarUsuarios(){

        ModelAndView mv = new ModelAndView("usuariosListar");

        return mv;

    }

    @GetMapping("/criar")
    public String criarUsuarios(){

        return "usuariosCriar";

    }
}
