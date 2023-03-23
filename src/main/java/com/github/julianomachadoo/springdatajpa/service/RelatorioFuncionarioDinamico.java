package com.github.julianomachadoo.springdatajpa.service;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import com.github.julianomachadoo.springdatajpa.repository.FuncionarioRepository;
import com.github.julianomachadoo.springdatajpa.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;
import java.util.Scanner;

public class RelatorioFuncionarioDinamico {

    private final FuncionarioRepository funcionarioRepository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite um nome");
        String nome = scanner.next();

        List<Funcionario> funcionarios = funcionarioRepository
                .findAll(Specification.where(SpecificationFuncionario.nome(nome)));
    }
}
