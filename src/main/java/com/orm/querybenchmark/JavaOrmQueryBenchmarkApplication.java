package com.orm.querybenchmark;

import com.orm.querybenchmark.dao.ActorDAO;
import com.orm.querybenchmark.dao.ActorDaoCriteriaBuilderImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JavaOrmQueryBenchmarkApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaOrmQueryBenchmarkApplication.class, args);
	}
}

