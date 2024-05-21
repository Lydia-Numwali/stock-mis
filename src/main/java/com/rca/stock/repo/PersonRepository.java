package com.rca.stock.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rca.stock.models.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
