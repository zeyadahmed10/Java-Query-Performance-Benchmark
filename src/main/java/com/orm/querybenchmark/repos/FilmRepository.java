package com.orm.querybenchmark.repos;

import com.orm.querybenchmark.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Integer> {
}