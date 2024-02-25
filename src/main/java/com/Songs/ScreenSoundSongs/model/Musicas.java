package com.Songs.ScreenSoundSongs.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musica")
public class Musicas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nomeMusica;
	
	private String album;
	
	@ManyToOne
	private Artistas artista;
	
	public Musicas() {
	}

	public Musicas(String nomeMusica, String album) {
		this.nomeMusica = nomeMusica;
		this.album = album;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nomeMusica;
	}

	public void setNome(String nome) {
		this.nomeMusica = nome;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Artistas getArtista() {
		return artista;
	}

	public void setArtista(Artistas artista) {
		this.artista = artista;
	}
	
	@Override
	public String toString() {
	    return
	        "Música='" + nomeMusica + '\'' +
	        "Album='" + album + '\'' +
	        ", artista=" + artista.getNome();
	}
}
