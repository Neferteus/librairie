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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "edition", catalog = "librairie")
public class Edition implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idEdition", unique = true, nullable = false)
	private Integer idEdition = 0;
	@Column(name = "nomEdition", nullable = false, length = 50)
	private String nomEdition = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "edition")
	private Set<Livre> livres = new HashSet<Livre>(0);
	@OneToOne
	@JoinColumn(name = "edition_idAdresse", referencedColumnName = "idAdresse", nullable = false)
	private Adresse adresse = null;
	
	public Edition(){
		
	}

	public Integer getIdEdition() {
		return idEdition;
	}

	public void setIdEdition(Integer idEdition) {
		this.idEdition = idEdition;
	}

	public String getNomEdition() {
		return nomEdition;
	}

	public void setNomEdition(String nomEdition) {
		this.nomEdition = nomEdition;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
}
