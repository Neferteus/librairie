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
@Table(name = "format", catalog = "librairie")
public class Format implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFormat", unique = true, nullable = false)
	private Integer idFormat = 0;
	@Column(name = "nomFormat", nullable = false, length = 20)
	private String nomFormat = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "format")
	private Set<Livre> livres = new HashSet<Livre>(0);

	public Format(){
		
	}

	public Integer getIdFormat() {
		return idFormat;
	}

	public void setIdFormat(Integer idFormat) {
		this.idFormat = idFormat;
	}

	public String getNomFormat() {
		return nomFormat;
	}

	public void setNomFormat(String nomFormat) {
		this.nomFormat = nomFormat;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}
	
}
