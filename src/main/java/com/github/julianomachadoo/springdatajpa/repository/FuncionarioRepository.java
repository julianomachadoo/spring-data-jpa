package com.github.julianomachadoo.springdatajpa.repository;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import com.github.julianomachadoo.springdatajpa.orm.FuncionarioProjecao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario, Integer> , JpaSpecificationExecutor<Funcionario> {
    List<Funcionario> findByNome(String nome);

    @Query("SELECT f FROM Funcionario f WHERE f.nome = :nome AND f.salario >= :salario AND f.dataContratacao = :data")
    List<Funcionario> findNomeDataContratacaoSalarioMaior(String nome, Double salario, LocalDate data);

    //    @Query( value = "SELECT * FROM funcionarios f WHERE f.data_contratacao >= :data", nativeQuery = true)
    @Query("SELECT f FROM Funcionario f WHERE f.dataContratacao >= :data")
    List<Funcionario> findDataContratacaoMaior(LocalDate data);

    Page<Funcionario> findAll(Pageable pageable);

    @Query(value = "SELECT f.id, f.nome, f.salario FROM funcionarios f",
            nativeQuery = true)
    List<FuncionarioProjecao> findFuncionarioSalario();
}
