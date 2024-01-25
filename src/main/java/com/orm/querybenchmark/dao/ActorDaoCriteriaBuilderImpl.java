package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.entity.Category;
import com.orm.querybenchmark.entity.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.CacheMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Repository
@Profile("criteria")
public class ActorDaoCriteriaBuilderImpl implements ActorDAO{
    //note less error-prone always runs from the first type as its type safe but its verbose and need more writing
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Actor> findAll() {
        List<Actor> actors = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            session.setCacheMode(CacheMode.IGNORE);
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(Actor.class);
            var root = criteriaQuery.from(Actor.class);
            criteriaQuery.select(root);
            actors = entityManager.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return actors;
    }

    @Override
    public Actor findById(Integer id) {
        Actor actor = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            session.setCacheMode(CacheMode.IGNORE);
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(Actor.class);
            var root = criteriaQuery.from(Actor.class);
            var condition = criteriaBuilder.equal(root.get("id"), id);
            criteriaQuery.where(condition);
            actor = entityManager.createQuery(criteriaQuery).getSingleResult();
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return actor;
    }

    @Override
    public void save(Actor actor) {

    }

    @Override
    public List<Actor> findAllByCategory(String category) {
        List<Actor> actors = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            session.setCacheMode(CacheMode.IGNORE);
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(Actor.class);
            Root<Actor> actorRoot = criteriaQuery.from(Actor.class);
            Join<Actor, Film> actorFilmJoin = actorRoot.join("films");
            Join<Film, Category> filmCategoryJoin = actorFilmJoin.join("category");
            Predicate condition = criteriaBuilder.equal(filmCategoryJoin.get("name"), category);
            criteriaQuery.where(condition);
            actors = entityManager.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return actors;
    }

    @Override
    public List<Actor> findAllByFilmReleaseYear(Integer year) {
        List<Actor> actors = null;
        try{
            Session session = entityManager.unwrap(Session.class);
            session.setCacheMode(CacheMode.IGNORE);
            CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
            var criteriaQuery = criteriaBuilder.createQuery(Actor.class);
            var actorRoot = criteriaQuery.from(Actor.class);
            Join<Actor, Film>  actorFilmJoin = actorRoot.join("films");
            var condition = criteriaBuilder.equal(actorFilmJoin.get("releaseYear"),year);
            criteriaQuery.where(condition);
            actors = entityManager.createQuery(criteriaQuery).getResultList();
        }catch (Exception e) {
            log.error(e.getMessage());
        }
        return actors;
    }
}
