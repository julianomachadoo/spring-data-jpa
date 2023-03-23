package com.github.julianomachadoo.springdatajpa.service;

import com.github.julianomachadoo.springdatajpa.orm.Funcionario;
import com.github.julianomachadoo.springdatajpa.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

@Service
public class RelatoriosService {

    private boolean system = true;
    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private final FuncionarioRepository funcionarioRepository;

    public RelatoriosService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public void inicial(Scanner scanner) {

        while (system) {
            System.out.println();
            System.out.println("Qual ação de cargo deseja executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Busca funcionario por nome");
            System.out.println("2 - Busca funcionario por nome, data contratacao e salario maior");
            System.out.println("3 - Busca funcionario data contratacao");

            int action = scanner.nextInt();

            switch (action) {
                case 1 -> buscaFuncionarioPorNome(scanner);
                case 2 -> buscaFuncionarioNomeSalarioMaiorData(scanner);
                case 3 -> buscaFuncionarioDataContratacao(scanner);
                default -> system = false;
            }
        }
    }

    private void buscaFuncionarioPorNome(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();
        List<Funcionario> list = funcionarioRepository.findByNome(nome);
        list.forEach(System.out::println);
    }

    private void buscaFuncionarioNomeSalarioMaiorData(Scanner scanner) {
        System.out.println("Qual nome deseja pesquisar?");
        String nome = scanner.next();

        System.out.println("Qual data de contratacao deseja pesquisar?");
        String dataContratacao = scanner.next();
        LocalDate localDate = LocalDate.parse(dataContratacao, formatter);

        System.out.println("Qual salario deseja pesquisar?");
        Double salario = scanner.nextDouble();

        List<Funcionario> funcionarios = funcionarioRepository
                .findNomeDataContratacaoSalarioMaior(nome, salario, localDate);
        funcionarios.forEach(System.out::println);
    }

    private void buscaFuncionarioDataContratacao(Scanner scanner) {
        System.out.println("Qual data deseja pesquisar?");
        String data = scanner.next();
        LocalDate localDate = LocalDate.parse(data, formatter);

        List<Funcionario> funcionarios = funcionarioRepository.findDataContratacaoMaior(localDate);
        funcionarios.forEach(System.out::println);
    }
}
