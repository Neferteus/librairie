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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "collection", catalog = "librairie")
public class Collection implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCollection", unique = true, nullable = false)
	private Integer idCollection = 0;
	@Column(name = "nomCollection", nullable = false, length = 50)
	private String nomCollection = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "collection")
	private Set<Livre> livres = new HashSet<Livre>(0);
	
	public Collection(){
		
	}

	public Integer getIdCollection() {
		return idCollection;
	}

	public void setIdCollection(Integer idCollection) {
		this.idCollection = idCollection;
	}

	public String getNomCollection() {
		return nomCollection;
	}

	public void setNomCollection(String nomCollection) {
		this.nomCollection = nomCollection;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
