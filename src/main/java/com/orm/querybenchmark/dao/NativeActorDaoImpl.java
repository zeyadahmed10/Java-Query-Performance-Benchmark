package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.mappers.ActorRowMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
public class NativeActorDaoImpl implements ActorDAO{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Actor> findAll() {
        String query = "SELECT * FROM public.actor";
        List<Actor> actors = new ArrayList<Actor>();
        try{
            return jdbcTemplate.query(query, new ActorRowMapper());
        }catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public Actor findById(Integer id) {
        // TODO notice it error prone missed actor_id and typed id only
        String query = "SELECT * FROM public.actor where public.actor.actor_id = ?";
        try{
            return jdbcTemplate.queryForObject(query, new ActorRowMapper(), new Object[]{id});
        }
        catch (Exception e){
            log.error(e.getMessage());
            throw e;
        }
    }

    @Override
    public void save(Actor actor) {
    }
}
