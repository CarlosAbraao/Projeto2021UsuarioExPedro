package com.carlosdev.aplicacaoWeb.controller;


import com.carlosdev.aplicacaoWeb.entities.Acesso;
import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.AcessoRepository;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/acesso")
public class AcessoController {

    @Autowired
    private AcessoRepository acessoRepository;

    @GetMapping
    public String PaginaAcesso(){

        Acesso acesso = new Acesso();

       acesso.setPagina("paginaInicial");
       Date date = new Date();

       date.getTime();

       acesso.setData(date);

       acessoRepository.save(acesso);

        List<Acesso> acessoList = acessoRepository.findAll();

        System.out.println(acessoList.size());

         return "paginaInicial";
    }
}
