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
public class ActorDaoNativeImpl implements ActorDAO{
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
        }
        return null;
    }

    @Override
    public Actor findById(Integer id) {
        // TODO notice it error prone missed actor_id and typed id only
        String query = "SELECT * FROM public.actor where public.actor.actor_id = ?";
        try{
            return jdbcTemplate.queryForObject(query, new ActorRowMapper(), id);
        }
        catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public void save(Actor actor) {
    }

    @Override
    public List<Actor> findAllByCategory(String category) {
        String query = "SELECT Distinct act.actor_id, act.first_name, act.last_name FROM actor act " +
                "JOIN film_actor ON act.actor_id = film_actor.actor_id " +
                "JOIN (SELECT f.film_id FROM film f JOIN category cat " +
                "ON f.category_id = cat.category_id WHERE cat.name = ? ) AS subfilm " +
                "ON film_actor.film_id=subfilm.film_id;";
        try{
            return jdbcTemplate.query(query, new ActorRowMapper(), category);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

    @Override
    public List<Actor> findAllByFilmReleaseYear(Integer year) {
        String query = "select Distinct actor.actor_id, actor.first_name, actor.last_name" +
                " from actor join film_actor fa on actor.actor_id = fa.actor_id\n" +
                "join film f on fa.film_id = f.film_id where f.release_year = ?;";
        try{
            return jdbcTemplate.query(query, new ActorRowMapper(), year);
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return null;
    }

}
