package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class ActorDaoCriteriaBuilderImpl implements ActorDAO{
    @Override
    public List<Actor> findAll() {
        return null;
    }

    @Override
    public Actor findById(Integer id) {
        return null;
    }

    @Override
    public void save(Actor actor) {

    }

    @Override
    public List<Actor> findAllByCategory(String category) {
        return null;
    }

    @Override
    public List<Actor> findAllByFilmReleaseYear(Integer year) {
        return null;
    }
}
