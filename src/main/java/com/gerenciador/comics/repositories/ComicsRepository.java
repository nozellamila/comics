package com.gerenciador.comics.repositories;

import com.gerenciador.comics.domains.Comics;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComicsRepository extends JpaRepository<Comics, Integer> {
}
