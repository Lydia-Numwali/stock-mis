package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
}
