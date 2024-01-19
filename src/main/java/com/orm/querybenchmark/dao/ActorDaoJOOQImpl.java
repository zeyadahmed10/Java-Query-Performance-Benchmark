package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import static org.jooq.generated.public_.tables.Actor.ACTOR;
import static org.jooq.generated.public_.tables.Film.FILM;
import static org.jooq.generated.public_.tables.FilmActor.FILM_ACTOR;

import com.orm.querybenchmark.mappers.ActorRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.jooq.DSLContext;
import org.jooq.SelectConditionStep;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class ActorDaoJOOQImpl implements ActorDAO{

    private final DSLContext dslContext;

    public ActorDaoJOOQImpl(DSLContext dslContext) {
        this.dslContext = dslContext;
    }

    @Override
    public List<Actor> findAll() {
        var records = this.dslContext
                .select().from(ACTOR).fetch();
        if(records==null){
            log.error("No records found in Actor table");
            return null;
        }
        return ActorRowMapper.mapActorRecord(records);
    }

    @Override
    public Actor findById(Integer id) {
        var record = this.dslContext
                .select().from(ACTOR).where(ACTOR.ACTOR_ID.eq(id))
                .fetchOne();
        if(record==null){
            log.error("Could not find actor");
            return null;
        }
        return ActorRowMapper.mapActorRecord(record);
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
        var records= dslContext
                .selectDistinct(ACTOR.ACTOR_ID, ACTOR.FIRST_NAME, ACTOR.LAST_NAME)
                .from(ACTOR)
                .join(FILM_ACTOR).on(ACTOR.ACTOR_ID.eq(FILM_ACTOR.ACTOR_ID))
                .join(FILM).on(FILM_ACTOR.FILM_ID.eq(FILM.FILM_ID))
                .and(FILM.RELEASE_YEAR.eq(year)).fetch();
        if(records==null){
            log.error("No records found with year: "+year);
            return null;
        }
        return ActorRowMapper.mapActorRecord(records);
    }
}
