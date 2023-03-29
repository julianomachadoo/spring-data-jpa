package com.github.julianomachadoo.springdatajpa.service;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import com.github.julianomachadoo.springdatajpa.repository.FuncionarioRepository;
import com.github.julianomachadoo.springdatajpa.specification.SpecificationFuncionario;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatorioFuncionarioDinamico {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatorioFuncionarioDinamico(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {
        System.out.println("Digite um nome:");
        String nome = scanner.next();

        if (nome.equalsIgnoreCase("NULL")) {
            nome = null;
        }

        System.out.println("Digite um cpf:");
        String cpf = scanner.next();

        if (cpf.equalsIgnoreCase("NULL")) {
            cpf = null;
        }

        System.out.println("Digite um salario:");
        Double salario = scanner.nextDouble();

        if (salario == 0) {
            salario = null;
        }

        System.out.println("Digite uma data:");
        String data = scanner.next();

        LocalDate dataContratacao;

        if (data.equalsIgnoreCase("NULL")) {
            dataContratacao = null;
        } else {
            dataContratacao = LocalDate.parse(data, formatter);
        }

        List<Funcionario> funcionarios = funcionarioRepository
                .findAll(Specification
                        .where(SpecificationFuncionario.nome(nome))
                        .and(SpecificationFuncionario.cpf(cpf))
                        .and(SpecificationFuncionario.salario(salario))
                        .and(SpecificationFuncionario.dataContratacao(dataContratacao))
                );
        funcionarios.forEach(System.out::println);
    }
}
