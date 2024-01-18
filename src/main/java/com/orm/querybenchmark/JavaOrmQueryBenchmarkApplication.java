package com.orm.querybenchmark;

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
	CommandLineRunner commandLineRunner(CategoryRepository categoryRepository, FilmRepository filmRepository){
		return args -> {
			System.out.println(categoryRepository.findById(1).get());
			System.out.println(filmRepository.findById(1).get());
		};
	}
}
