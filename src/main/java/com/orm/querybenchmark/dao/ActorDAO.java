package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;

import java.util.List;

public interface ActorDAO {
    //select
    List<Actor> findAll();
    Actor findById(Integer id);
    //insert
    void save(Actor actor);
    //delete
    //join with sub queries
    List<Actor> findAllByCategory(String category);
    List<Actor> findAllByFilmReleaseYear(Integer year);
}
