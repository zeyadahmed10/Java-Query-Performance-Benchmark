package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.repos.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class ActorNativeQueryImpl implements ActorDAO {

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return actorRepository.nativeFindAll();
    }

    @Override
    public Actor findById(Integer id) {
        return actorRepository.nativeFindById(id);
    }

    @Override
    public void save(Actor actor) {

    }
}
