package com.gerenciador.comics.repositories;

import com.gerenciador.comics.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}
