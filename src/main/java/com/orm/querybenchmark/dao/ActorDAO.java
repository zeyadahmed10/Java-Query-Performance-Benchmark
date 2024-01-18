package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;

import java.util.List;

public interface ActorDAO {
    //select
    List<Actor> findAll();
    Actor findById(Integer id);
    //insert
    Actor save(Actor actor);
    //delete

}
