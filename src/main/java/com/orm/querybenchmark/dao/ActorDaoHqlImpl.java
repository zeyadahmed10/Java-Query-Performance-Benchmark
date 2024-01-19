package com.orm.querybenchmark.dao;

import com.orm.querybenchmark.entity.Actor;
import jakarta.persistence.Query;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.List;
@Slf4j
@Repository
public class ActorDaoHqlImpl implements ActorDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public List<Actor> findAll() {
        List<Actor> actors = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            String hql = "from Actor";
            Query query = session.createQuery(hql, Actor.class);
            actors = query.getResultList();
            session.getTransaction().commit();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return actors;
    }

    @Override
    public Actor findById(Integer id) {
        Actor actor = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            String hql = "from Actor where id = :id";
            Query query = session.createQuery(hql, Actor.class);
            query.setParameter("id", id);
            actor = (Actor)query.getSingleResult();
            session.getTransaction().commit();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return actor;
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
        List<Actor> actors = null;
        try(Session session = sessionFactory.openSession()){
            session.beginTransaction();
            String hql = "from Actor act JOIN act.films f where f.releaseYear = :year ";
            Query query = session.createQuery(hql, Actor.class);
            query.setParameter("year", year);
            actors = query.getResultList();
            session.getTransaction().commit();
        }catch (Exception e){
            log.error(e.getMessage());
        }
        return actors;
    }
}
