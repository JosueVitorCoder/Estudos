package Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "musicas")
public class Musica {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String singleTitulo;
	private String album;
	@ManyToOne
	private Artista artista;
	
	public Musica() {}

	public Musica(String singleTitulo, Artista artista) {
		this.singleTitulo = singleTitulo;
		this.artista = artista;
	}

	public Musica(String singleTitulo, String album, Artista artista) {
		this.singleTitulo = singleTitulo;
		this.album = album;
		this.artista = artista;
	}

	public String getSingleTitulo() {
		return singleTitulo;
	}

	public void setSingleTitulo(String singleTitulo) {
		this.singleTitulo = singleTitulo;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public Artista getArtista() {
		return artista;
	}

	public void setArtistas(Artista artista) {
		this.artista = artista;
	}
	
}
