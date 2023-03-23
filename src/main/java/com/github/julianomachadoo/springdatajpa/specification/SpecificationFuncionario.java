package com.github.julianomachadoo.springdatajpa.specification;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criterioQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
    }
}
