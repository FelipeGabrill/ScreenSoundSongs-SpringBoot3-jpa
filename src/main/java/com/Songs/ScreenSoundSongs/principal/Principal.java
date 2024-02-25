package com.Songs.ScreenSoundSongs.principal;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.Songs.ScreenSoundSongs.model.Artistas;
import com.Songs.ScreenSoundSongs.model.Musicas;
import com.Songs.ScreenSoundSongs.model.TipoArtista;
import com.Songs.ScreenSoundSongs.repository.ArtistaRepository;
import com.Songs.ScreenSoundSongs.service.ConsultaChatGPT;

public class Principal {

	Scanner sc = new Scanner(System.in);
	
	private final ArtistaRepository repositorio;
	
	public Principal(ArtistaRepository repositorio) {
		this.repositorio = repositorio;
	}

	public void exibeMenu() {
		var opcao = -1;
		while (opcao != 9) {
			var menu = 
					"""
					1- Cadastrar artistas
					2- Cadastrar músicas
					3- Listar músicas
					4- Buscar músicas por artistas
					5- Pesquisar dados sobre um artista
					9- Sair""";
			
			System.out.println(menu);
			System.out.print("Digite uma opcao: ");
			opcao = sc.nextInt();
			sc.nextLine();
			
			switch (opcao) {
			
			case 1: 
				cadastrarArtista();
				break;
			case 2: 
				cadastrarMusicas();
				break;
			case 3:
				listarMusicas();
				break;
			case 4:
				buscarMusicaPorArtista();
				break;
			case 5: 
				PesquisarDadosSobreArtista();
				break;
			case 9: 
				System.out.println("Saindo...");
				break;
			default: 
				System.out.println("Opcao invalida");
			
			}
		}	
			
	}	

	public void cadastrarArtista() {
		String continuar = "S";
		while (continuar.equalsIgnoreCase("s")) {
			System.out.print("Informe o nome do artista: ");
			var nomeArtista = sc.nextLine();
		
			System.out.print("Informe o tipo desse artista (solo, dupla ou banda): ");
			var tipo = sc.nextLine().toLowerCase();
			
			try {
			TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toUpperCase());
				
			Artistas artista = new Artistas(nomeArtista, tipoArtista);
				
			repositorio.save(artista);
			} catch (Exception e) {
				System.out.println("Tipo invalido!");
			}
			
			System.out.print("Cadastrar outro artista (S/N):");
			continuar = sc.nextLine().toUpperCase();	
		}
	}
	
	 private void cadastrarMusicas() {
		 System.out.print("Cadastrar música de que artista: ");
	     var nome = sc.nextLine();
	     Optional<Artistas> artista = repositorio.findByNomeIgnoreCase(nome);
	     if (artista.isPresent()) {
	         System.out.print("Informe o título da música: ");
	         var nomeMusica = sc.nextLine();
	         System.out.print("Informe o nome do album: ");
	         var nomeAlbum = sc.nextLine();
	         Musicas musica = new Musicas(nomeMusica, nomeAlbum);
	         musica.setArtista(artista.get());
	         artista.get().getMusicas().add(musica);
	         repositorio.save(artista.get());
        } else {
        	 System.out.println("Artista não encontrado");
	    }
	 }
	 
	private void listarMusicas() {
		List<Artistas> artistas = repositorio.findAll();
	    artistas.forEach(a -> a.getMusicas().forEach(System.out::println));
	}


	private void buscarMusicaPorArtista() {
		System.out.print("Digite o nome do artista: ");
		var nomeAtista = sc.nextLine();
	    List<Musicas> musicas = repositorio.buscaMusicasPorArtista(nomeAtista);
	    musicas.forEach(System.out::println);
	}
	
	public void PesquisarDadosSobreArtista() {
		System.out.print("Digite o nome do artista: ");
		var nomeArtista = sc.nextLine();
		var resposta  = ConsultaChatGPT.obterInformacoesArtista(nomeArtista);
		System.out.println(resposta.trim());
	}
}
