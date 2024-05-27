package com.alura.artist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import principal.Principal;
import repositorio.copy.ArtistaRepository;

@SpringBootApplication
public class ArtistApplication implements CommandLineRunner{
	@Autowired
	ArtistaRepository repositorio;
	
	public static void main(String[] args) {
		SpringApplication.run(ArtistApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
		principal.exibeMenu();
	}
}