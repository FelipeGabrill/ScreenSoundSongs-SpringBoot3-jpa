package com.Songs.ScreenSoundSongs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Songs.ScreenSoundSongs.principal.Principal;
import com.Songs.ScreenSoundSongs.repository.ArtistaRepository;

@SpringBootApplication
public class ScreenSoundSongsApplication implements CommandLineRunner  {
	
	@Autowired
	private ArtistaRepository repositorio;

	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundSongsApplication.class, args);
	}	

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repositorio);
	    principal.exibeMenu();
	}
}
