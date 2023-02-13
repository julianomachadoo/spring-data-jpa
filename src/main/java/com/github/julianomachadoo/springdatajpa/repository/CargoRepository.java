package com.github.julianomachadoo.springdatajpa.repository;

import com.github.julianomachadoo.springdatajpa.orm.Cargo;
import org.springframework.data.repository.CrudRepository;

public interface CargoRepository extends CrudRepository<Cargo, Integer> {
}
