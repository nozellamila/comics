package com.gerenciador.comics.repositories;

import com.gerenciador.comics.domains.Comics;
import com.gerenciador.comics.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Optional<Usuario> findByEmail(String email);

    Optional<Usuario> findByCpf(String cpf);

    Optional<Usuario> findByComics(Comics comic);
}
