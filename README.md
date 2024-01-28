# Java Persistence Benchmarking Project

## Overview:
In the world of Java persistence, developers are presented with plenty of choices when it comes to interacting with the database. Each approach promises its own advantages, and choosing the right one often feels like a puzzle. In the pursuit of query safety, expressiveness, and optimal performance, it becomes necessary to not only understand the puzzle but also benchmark each approach.

This project aims to provide insights into various Java persistence approaches including Native Query, HQL, CriteriaBuilder, Querydsl, and jOOQ. Through comprehensive benchmarking and analysis, the project evaluates the advantages, drawbacks, and performance of each approach.
## Note
For comprehensive guide and analysis for the experiment based on Performance concering database size, Expressiveness, Ease of Use, and Query Type Safety with visualizations for results read the experiment medium article.
[Comprehensive Guide to Decoding the Java Persistence Puzzle: JMH Benchmarking of Native Query, HQL, CriteriaBuilder, Querydsl, and jOOQ](https://medium.com/@zeyadahmedcs/comprehensive-guide-to-decoding-the-java-persistence-puzzle-jmh-benchmarking-of-native-query-hql-108fd7220c54)
## Table of Contents
- [Project Highlitghts](#project-highlights)
- [Tools and Technologies](#tools-and-technologies)
- [Database Info](#database-info)
- [Results](#results)
- [How to Rerun The Experiment](#how-to-rerun-the-experiment)
## Project Highlights:
- **Comprehensive Benchmarking:** Conducted benchmarking for Native Query + JDBC, Hibernate (HQL), Criteria API, QueryDSL, and jOOQ using JMH.
- **Performance Analysis:** Analyzed performance across small (30K), medium (100K), and large (300K) IMDb database sizes to provide insights into scalability and efficiency.
- **Publication:** Published findings in a [Medium](https://medium.com/@zeyadahmedcs/comprehensive-guide-to-decoding-the-java-persistence-puzzle-jmh-benchmarking-of-native-query-hql-108fd7220c54) article with detailed performance analysis and visualizations, contributing to the understanding of Java persistence best practices.
## Tools and Technologies
- **Java 17**
- **Spring Boot** - version 3.2.1
- **JMH** -version 1.37
- **Postgres**
- **Spring Data Jpa**
- **Hibernate**
- **Criteria API**
- **Querydsl**
- **Spring jOOQ**
- **Lombok**
- **JUnit & Mockito**
- **Maven**
## Database Info
Database size for the three variations:

![micro](https://github.com/zeyadahmed10/Java-Query-Performance-Benchmark/blob/master/database%20size.png)
## Results
Benchmark results for the small, medium and, large databases
1. Small Database Results:

   ![micro](https://github.com/zeyadahmed10/Java-Query-Performance-Benchmark/blob/master/smallResult.png)

2. Medium Database Results:

   ![micro](https://github.com/zeyadahmed10/Java-Query-Performance-Benchmark/blob/master/mediumRes.png)

3. Large Database Results:

   ![micro](https://github.com/zeyadahmed10/Java-Query-Performance-Benchmark/blob/master/largeRes.png)
   
## How to Rerun The Experiment:
1. Clone the repository to your local machine.
   ```bash
   git clone https://github.com/zeyadahmed10/Java-Query-Performance-Benchmark.git
   
2. Set up the required environment with Docker.
   ```bash
   docker-compose up -d
3. Initialize the database with scripts found under `src/main/resoucres/db`
4. Generate class for jOOQ and QClass for Querydsl
    ```bash
      mvn clean org.jooq:jooq-codegen-maven:3.18.7:generate compile

5. Choose the test enviroment based on the DAO implementation `(native - hql - criteria - qdsl - jooq)`   
6. Build and run the project using Maven or your preferred IDE.
7. Explore the benchmarking results and analysis provided in the project under `src/main/resources/results`.

