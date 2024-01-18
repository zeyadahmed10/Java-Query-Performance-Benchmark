package com.orm.querybenchmark.repos;

import com.orm.querybenchmark.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}