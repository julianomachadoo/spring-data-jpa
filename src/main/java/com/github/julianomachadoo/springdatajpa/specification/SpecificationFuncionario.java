package com.github.julianomachadoo.springdatajpa.specification;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class SpecificationFuncionario {

    public static Specification<Funcionario> nome(String nome) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (nome == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.like(root.get("nome"), "%" + nome + "%");
        };
    }

    public static Specification<Funcionario> cpf(String cpf) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (cpf == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.equal(root.get("cpf"), cpf);
        };

    }

    public static Specification<Funcionario> salario(Double salario) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (salario == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThan(root.get("salario"), salario);
        };
    }

    public static Specification<Funcionario> dataContratacao(LocalDate dataContratacao) {
        return (root, criteriaQuery, criteriaBuilder) -> {
            if (dataContratacao == null) return criteriaBuilder.conjunction();
            return criteriaBuilder.greaterThan(root.get("dataContratacao"), dataContratacao);
        };
    }
}
