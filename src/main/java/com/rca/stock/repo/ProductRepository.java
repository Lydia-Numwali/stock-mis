package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
