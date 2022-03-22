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


    public Boolean save(Usuario usuario) {

        // VERIFICAR SE O USUARIO EXISTE
        // SE O CAMPO EMAIL FOR IGUAL A NULL ELE SALVA O USUARIO E RETORNA TRUE, SENÃO RETORNA FALSE E N SALVA O USUARIO


        Usuario usuarioEmailEncontrado = findUsuarioByEmail(usuario.getEmail());
        // SE O EMAIL DO USUARIO ESTIVER VAZIO VAI EXIBIR UMA MENSSAGEM
        if (usuario.getEmail().equals("")){


            if(usuarioEmailEncontrado == null){
                usuarioRepository.save(usuario);
                return true;
            }
            return false;
        }
       return false;


    }

    public Usuario findUsuarioById(Long id) {
        Usuario usuarioId = usuarioRepository.findUsuarioById(id);

        return usuarioId;
    }

    public Usuario findUsuarioByEmail(String email) {
        Usuario usuarioEmail = usuarioRepository.findUsuarioByEmail(email);

        return usuarioEmail;
    }


    public void delete(Usuario usuario) {
         usuarioRepository.delete(usuario);
    }
}
