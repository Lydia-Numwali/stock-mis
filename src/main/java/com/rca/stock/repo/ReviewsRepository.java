package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.Reviews;

@Repository
public interface ReviewsRepository extends JpaRepository<Reviews, Integer> {
}
