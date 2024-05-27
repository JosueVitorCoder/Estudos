package principal;

import java.util.Scanner;



import Models.Artista;
import Models.TypeArtista;
import repositorio.copy.ArtistaRepository;

public class Principal {
	ArtistaRepository repositorio;
	Scanner sc = new Scanner(System.in);

	public Principal(ArtistaRepository repositorio) {
		this.repositorio = repositorio;
	}
	
	public void exibeMenu() {
		
		var exibir = """
				** Alura Sound Claund **
				
				1 - Cadastrar Artistas
				2 - Cadastrar Músicas
				3 - Listar Músicas
				4 - Buscar Músicas por Artistas
				5 - Pesquisar dados sobre um artista
				
				0 - Sair
				""";
		System.out.println(exibir);
		int in = sc.nextInt();
		int correto = -1;
		while(correto == -1) {
			switch(in) {
			case 1:
				cadastrarArtistas();
				correto = 0;
				break;
			case 2:
				cadastarMusicas();
				correto = 0;
				break;
			case 3:
				listarMusicas();
				correto = 0;
				break;
			case 4:
				buscarMusicasPorArtistas();
				correto = 0;
				break;
			case 5:
				pesquisarDadosSobreUmArtista();
				correto = 0;
				break;
			}
		}
	}

	private void buscarMusicasPorArtistas() {
		// TODO Auto-generated method stub
		
	}

	private void listarMusicas() {
		// TODO Auto-generated method stub
		
	}

	private void cadastarMusicas() {
		// TODO Auto-generated method stub
		
	}

	private void cadastrarArtistas() {
		TypeArtista type = null;
		var cadastrarNovo = "S";
		
		while(cadastrarNovo.equalsIgnoreCase("S")) {
			System.out.println("Qual o vulgo do artista? ");
			sc.nextLine();
			var vulgo = sc.nextLine(); 
		    System.out.println("O artista em questão é (1 = solo, 2 = dupla, 3 = banda)?");
		    
		    int correto = -1;
		    while(correto == -1) {
		    	System.out.print("Digite o número correspondente: ");
			    var nun = sc.nextInt();
		    	switch(nun) {
			    case 1:
			    	correto = 0;
			    	type = TypeArtista.SOLO;
			    	break;
			    case 2:
			    	type = TypeArtista.DUPLA;
			    	correto = 0;
			    	break;
			    case 3:
			    	type = TypeArtista.BANDA;
			    	correto = 0;
			    	break;
		    	}
		    	if(correto == -1) {
		    		System.out.println("ERRO = Por favor digite um número correspondente: (1= solo, 2 = dupla, 3 = banda)");
		    	}
		    }
		    Artista artista = new Artista(vulgo, type);
		    repositorio.save(artista);
		}
	}
	
	private void pesquisarDadosSobreUmArtista() {
		// TODO Auto-generated method stub
		
	}
}
