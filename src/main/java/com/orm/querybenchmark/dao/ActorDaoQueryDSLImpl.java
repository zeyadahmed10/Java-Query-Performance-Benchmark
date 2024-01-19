package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.entity.QActor;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.annotation.PostConstruct;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Slf4j
public class ActorDaoQueryDSLImpl implements ActorDAO {
    private final JPAQueryFactory queryFactory;

    public ActorDaoQueryDSLImpl(EntityManager entityManager) {
        this.queryFactory = new JPAQueryFactory(entityManager);
    }

    @Override
    public List<Actor> findAll() {
        //QActor actor = QActor.actor;
        QActor actor = QActor.actor;
        return queryFactory.select(actor).from(actor).fetch();
    }

    @Override
    public Actor findById(Integer id) {
        QActor actor = QActor.actor;
        return queryFactory.select(actor).from(actor)
                .where(actor.id.eq(id)).fetchOne();
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
