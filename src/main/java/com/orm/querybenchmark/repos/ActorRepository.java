package com.orm.querybenchmark.repos;

import com.orm.querybenchmark.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ActorRepository extends JpaRepository<Actor, Integer> {
    @Query(nativeQuery = true, value = "SELECT * FROM public.actor")
    List<Actor> nativeFindAll();

    @Query(nativeQuery = true, value = "SELECT * FROM public.actor " +
            "where public.actor.actor_id = :idParam")
    Actor nativeFindById(@Param("idParam") Integer id);
}