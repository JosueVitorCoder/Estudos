package Models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "artistas")
public class Artista {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(unique = true)
	private String vulgo;
	@Enumerated(EnumType.STRING)
	private TypeArtista type;
	@OneToMany(mappedBy = "artista")
	private List<Musica> musicas = new ArrayList<Musica>();
	
	public Artista() {}
	
	public Artista(String vulgo, TypeArtista type) {
		this.vulgo = vulgo;
		this.type = type;
	}

	public Artista(String vulgo) {
		this.vulgo = vulgo;
	}

	public String getVulgo() {
		return vulgo;
	}

	public void setVulgo(String vulgo) {
		this.vulgo = vulgo;
	}

	public List<Musica> getMusicas() {
		return musicas;
	}
	
	public void addMusica(Musica musica) {
		musicas.add(musica);
	}

	@Override
	public String toString() {
		return "Artista [vulgo=" + vulgo + ", type=" + type + ", musicas=" + musicas + "]";
	}
	
	
}
