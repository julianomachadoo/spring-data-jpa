package com.github.julianomachadoo.springdatajpa;

import com.github.julianomachadoo.springdatajpa.orm.Cargo;
import com.github.julianomachadoo.springdatajpa.service.CrudCargoService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class SpringDataJpaApplication implements CommandLineRunner {

	private CrudCargoService cargoService;

	private Boolean system = true;

	public SpringDataJpaApplication(CrudCargoService cargoService) {
		this.cargoService = cargoService;
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
			System.out.println("1- Cargo");

			int action = scanner.nextInt();
			if (action == 1) {
				cargoService.inicial(scanner);
			} else {
				system = false;
			}
		}
	}
}
