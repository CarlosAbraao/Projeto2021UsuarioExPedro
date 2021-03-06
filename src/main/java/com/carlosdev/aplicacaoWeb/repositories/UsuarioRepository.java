package com.carlosdev.aplicacaoWeb.repositories;

import com.carlosdev.aplicacaoWeb.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Usuario findUsuarioById(Long id);

    Usuario findUsuarioByEmail(String email);
}
