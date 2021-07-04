package com.gerenciador.comics.repositories;

import com.gerenciador.comics.domains.Comics;
import com.gerenciador.comics.domains.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComicsRepository extends JpaRepository<Comics, Integer> {
    Optional<Comics> findByComicId(Integer comicId);

    Optional<Comics> findByUsuarios(Usuario usuario);
}
