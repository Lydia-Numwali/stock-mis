package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, Integer> {
}
