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
public class ActorDaoHqlImplBenchmark extends AbstractBenchmark{
    private static ActorDAO actorDAO;
    @Autowired
    public void setActorDAO(@Qualifier("actorDaoHqlImpl") ActorDAO actorDAO){
        ActorDaoHqlImplBenchmark.actorDAO = actorDAO;
    }
    @Benchmark
    public void benchmarkFindAll(){
        ActorDaoHqlImplBenchmark.actorDAO.findAll();
    }
    @Benchmark
    public void benchmarkFindById(){
        ActorDaoHqlImplBenchmark.actorDAO.findById(1);
    }
    @Benchmark
    public void benchmarkFindAllByCategory(){
        ActorDaoHqlImplBenchmark.actorDAO.findAllByCategory("Travel");
    }
    @Benchmark
    public void benchmarkFindAllByReleaseYear(){
        ActorDaoHqlImplBenchmark.actorDAO.findAllByFilmReleaseYear(2006);
    }
}
