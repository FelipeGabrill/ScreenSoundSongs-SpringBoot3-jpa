package com.Songs.ScreenSoundSongs.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artistas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true)
	private String nome;
	private TipoArtista tipoArtista;
	
	 @OneToMany(mappedBy = "artista", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Musicas> musicas = new ArrayList<>();
	
	public Artistas() {
		
	}

	public Artistas(String nome, TipoArtista tipoArtista) {
		this.nome = nome;
		this.tipoArtista = tipoArtista;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TipoArtista getTipoArtista() {
		return tipoArtista;
	}

	public void setTipoArtista(TipoArtista tipoArtista) {
		this.tipoArtista = tipoArtista;
	}

	public List<Musicas> getMusicas() {
		return musicas;
	}

	public void setMusicas(List<Musicas> musicas) {
		this.musicas = musicas;
	}
	
	@Override
	public String toString() {
	    return
	        "Artista='" + nome + '\''+
	        ", tipo=" + tipoArtista +
	        ", musicas=" + musicas;
	}
}
