package com.github.julianomachadoo.springdatajpa.repository;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends CrudRepository<Funcionario, Integer> {
    List<Funcionario> findByNome(String nome);
    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao = :data")
    List<Funcionario> findNomeDataContratacaoSalarioMaior(String nome, Double salario, LocalDate data);
}
