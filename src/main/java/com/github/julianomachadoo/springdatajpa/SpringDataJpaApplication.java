package com.github.julianomachadoo.springdatajpa;

import com.github.julianomachadoo.springdatajpa.service.CrudCargoService;
import com.github.julianomachadoo.springdatajpa.service.CrudFuncionarioService;
import com.github.julianomachadoo.springdatajpa.service.CrudUnidadeTrabalhoService;
import com.github.julianomachadoo.springdatajpa.service.RelatoriosService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

    private CrudCargoService cargoService;
    private CrudFuncionarioService funcionarioService;
    private CrudUnidadeTrabalhoService unidadeTrabalhoService;
    private RelatoriosService relatoriosService;

    private Boolean system = true;

    public SpringDataJpaApplication(CrudCargoService cargoService, CrudFuncionarioService crudFuncionarioService, CrudUnidadeTrabalhoService crudUnidadeTrabalhoService, RelatoriosService relatoriosService) {
        this.cargoService = cargoService;
        this.funcionarioService = crudFuncionarioService;
        this.unidadeTrabalhoService = crudUnidadeTrabalhoService;
        this.relatoriosService = relatoriosService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (system == true) {
            System.out.println("Qual a ação você quer executar?");
            System.out.println("0 - Sair");
            System.out.println("1 - Cargo");
            System.out.println("2 - Funcionario");
            System.out.println("3 - Unidade de Trabalho");
            System.out.println("4 - Relatórios");

            int action = scanner.nextInt();
            switch (action) {
                case 1:
                    cargoService.inicial(scanner);
                    break;
                case 2:
                    funcionarioService.inicial(scanner);
                    break;
                case 3:
                    unidadeTrabalhoService.inicial(scanner);
                    break;
                case 4:
                    relatoriosService.inicial(scanner);
                    break;
                default:
                    break;
            }
        }
    }
}
