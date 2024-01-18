package com.orm.querybenchmark;

import com.orm.querybenchmark.dao.ActorDAO;
import com.orm.querybenchmark.entity.Actor;
import com.orm.querybenchmark.repos.CategoryRepository;
import com.orm.querybenchmark.repos.FilmRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaOrmQueryBenchmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaOrmQueryBenchmarkApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, FilmRepository filmRepository, ActorDAO actorDAO){
		return args -> {
			var res = actorDAO.findAll();
			System.out.println(res);
			var x = actorDAO.findById(20);
			System.out.println(x.getId());
		};
	}
}
