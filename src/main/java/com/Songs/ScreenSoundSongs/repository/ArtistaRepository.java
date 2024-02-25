package com.Songs.ScreenSoundSongs.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Songs.ScreenSoundSongs.model.Artistas;
import com.Songs.ScreenSoundSongs.model.Musicas;

public interface ArtistaRepository extends JpaRepository<Artistas, Long>{

	Optional<Artistas> findByNomeIgnoreCase(String nomeArtista);

	@Query("SELECT m FROM Artistas a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musicas> buscaMusicasPorArtista(String nome);
	
}
