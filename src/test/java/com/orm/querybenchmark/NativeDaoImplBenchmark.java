package com.orm.querybenchmark;

import com.orm.querybenchmark.dao.ActorDAO;
import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.repos.ActorRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.openjdk.jmh.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.concurrent.TimeUnit;

@SpringBootTest
@State(Scope.Benchmark)
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.MICROSECONDS)
@ExtendWith(SpringExtension.class)
public class NativeDaoImplBenchmark extends AbstractBenchmark{


    private static ActorDAO actorDAO;
    private static ActorRepository actorRepository;
    @Autowired
    public void setActorDAO(ActorDAO actorDAO){
        NativeDaoImplBenchmark.actorDAO = actorDAO;
    }
    @Autowired
    public void setActorRepository(ActorRepository actorRepository){
        NativeDaoImplBenchmark.actorRepository = actorRepository;
    }
//    @Benchmark
//    public void testBenchmark(){
//        NativeDaoImplBenchmark.actorDAO.findById(1);
//    }
    @Benchmark
    public void testSave(){
        NativeDaoImplBenchmark.actorRepository.save(Actor.builder().id(3002).firstName("heshamm").lastName("ahmed").build());
    }
}
