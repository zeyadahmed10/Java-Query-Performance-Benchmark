package com.orm.querybenchmark.repos;

import com.orm.querybenchmark.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
}