package com.orm.querybenchmark;

import com.orm.querybenchmark.dao.ActorDAO;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MILLISECONDS)
public class ActorDaoBenchmark extends AbstractBenchmark{
    private static ActorDAO actorDAO;
    @Autowired
    public void setActorDAO(ActorDAO actorDAO){
        ActorDaoBenchmark.actorDAO = actorDAO;
    }
    @Benchmark
    public void benchmarkFindAll(){
        ActorDaoBenchmark.actorDAO.findAll();
    }
    @Benchmark
    public void benchmarkFindById(){
        ActorDaoBenchmark.actorDAO.findById(580467);
    }
    @Benchmark
    public void benchmarkFindAllByCategory(){
        ActorDaoBenchmark.actorDAO.findAllByCategory("Drama");
    }
    @Benchmark
    public void benchmarkFindAllByReleaseYear(){
        ActorDaoBenchmark.actorDAO.findAllByFilmReleaseYear(1991);
    }
}
