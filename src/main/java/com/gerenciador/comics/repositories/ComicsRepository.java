package com.gerenciador.comics.repositories;

import com.gerenciador.comics.domains.Comics;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ComicsRepository extends JpaRepository<Comics, Integer> {

    Optional<Comics> findByComicId(Integer comicId);

    @Query(nativeQuery = true, value ="SELECT c.id FROM Comics c " +
            "INNER JOIN Comic_Usuario cu " +
            "ON c.id = cu.comic_id " +
            "WHERE (cu.usuario_id = :usuarioId) " +
            "AND (c.comic_id = :comicId)")
    Comics findByQuery(@Param("usuarioId") Integer usuarioId,
                       @Param("comicId") Integer comicId);
}
