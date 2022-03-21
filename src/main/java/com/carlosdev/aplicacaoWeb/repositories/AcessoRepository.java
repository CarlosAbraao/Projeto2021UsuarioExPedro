package com.carlosdev.aplicacaoWeb.repositories;

import com.carlosdev.aplicacaoWeb.entities.Acesso;
import com.carlosdev.aplicacaoWeb.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AcessoRepository extends JpaRepository<Acesso, Long> {
}
