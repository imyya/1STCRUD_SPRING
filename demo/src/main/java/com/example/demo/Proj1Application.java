package com.example.demo;

import com.example.demo.model.Profil;
import com.example.demo.repository.ProfilRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Proj1Application {

	public static void main(String[] args) {
		SpringApplication.run(Proj1Application.class, args);
	}

    @Bean
	public CommandLineRunner run(ProfilRepository repos){
		return (args -> {
			InsertProfils(repos);
			System.out.println(repos.findAll());
		});
	}
	private void InsertProfils(ProfilRepository profilRepo){
		profilRepo.save(new Profil("ETUDIANT","ETU"));
		profilRepo.save(new Profil("ENSEIGNANT","ENS"));

	}


}
