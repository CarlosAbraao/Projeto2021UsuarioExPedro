package com.carlosdev.aplicacaoWeb.services;


import com.carlosdev.aplicacaoWeb.entities.Usuario;
import com.carlosdev.aplicacaoWeb.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {


    @Autowired
   private UsuarioRepository usuarioRepository;

    public List<Usuario> findAll(){

       return usuarioRepository.findAll();

    }


    public void save(Usuario usuario) {
        usuarioRepository.save(usuario);
    }

    public Usuario findUsuarioById(Long id) {
        Usuario usuarioId = usuarioRepository.findUsuarioById(id);

        return usuarioId;
    }

    public void delete(Usuario usuario) {
         usuarioRepository.delete(usuario);
    }
}
