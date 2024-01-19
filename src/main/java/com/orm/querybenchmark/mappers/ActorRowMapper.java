package com.orm.querybenchmark.mappers;

import com.orm.querybenchmark.entity.Actor;
import org.jooq.Record;
import org.jooq.Result;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static org.jooq.generated.public_.tables.Actor.ACTOR;

public class ActorRowMapper implements RowMapper<Actor> {

    @Override
    public Actor mapRow(ResultSet rs, int rowNum) throws SQLException {
        Actor actor = new Actor();
        actor.setId(rs.getInt("actor_id"));
        actor.setFirstName(rs.getString("first_name"));
        actor.setLastName(rs.getString("last_name"));
        return actor;
    }
    public static Actor mapActorRecord(Record record){
        return Actor.builder().id(record.get(ACTOR.ACTOR_ID))
                .firstName(record.get(ACTOR.FIRST_NAME))
                .lastName(record.get(ACTOR.LAST_NAME)).build();
    }
    public static <R extends Record> List<Actor> mapActorRecord(Result<R> records){
        List<Actor> actors = new ArrayList<Actor>();
        for(var record: records){
            actors.add(Actor.builder().id(record.get(ACTOR.ACTOR_ID))
                    .firstName(record.get(ACTOR.FIRST_NAME))
                    .lastName(record.get(ACTOR.LAST_NAME)).build());
        }
        return actors;
    }
}
