package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
