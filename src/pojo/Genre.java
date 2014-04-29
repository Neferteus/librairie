package pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;


@Entity
@Table(name = "genre", catalog = "librairie")
public class Genre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idGenre", unique = true, nullable = false)
	private Integer idGenre = 0;
	@Column(name = "nomGenre", nullable = false, length = 50)
	private String nomGenre = null;
	@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "livre_genre", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "genre_idGenre", nullable = false, updatable = false) }, inverseJoinColumns = {			
			@JoinColumn(name = "livre_idLivre", nullable = false, updatable = false)
	})
	private Set<Livre> livres = new HashSet<Livre>(0);

	public Genre(){
		
	}

	public Integer getIdGenre() {
		return idGenre;
	}

	public void setIdGenre(Integer idGenre) {
		this.idGenre = idGenre;
	}

	public String getNomGenre() {
		return nomGenre;
	}

	public void setNomGenre(String nomGenre) {
		this.nomGenre = nomGenre;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
