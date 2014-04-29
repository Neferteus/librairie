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
@Table(name = "pays", catalog = "librairie")
public class Pays implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPays", unique = true, nullable = false)
	private Integer idPays = 0;
	@Column(name = "codeIsoPays", nullable = false, length = 10)
	private String codeIsoPays = null;
	@Column(name = "nomPays", nullable = false, length = 50)
	private String nomPays = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "pays")
	private Set<Adresse> adresses = new HashSet<Adresse>(0);

	public Pays() {
	}

	public Integer getIdPays() {
		return idPays;
	}	
	public void setIdPays(Integer idPays) {
		this.idPays = idPays;
	}
	
	public String getCodeIsoPays() {
		return codeIsoPays;
	}

	public void setCodeIsoPays(String codeIsoPays) {
		this.codeIsoPays = codeIsoPays;
	}
	
	public String getNomPays() {
		return nomPays;
	}	
	public void setNomPays(String nomPays) {
		this.nomPays = nomPays;
	}	
	
	public Set<Adresse> getAdresses() {
		return adresses;
	}	
	public void setAdresses(Set<Adresse> adresses) {
		this.adresses = adresses;
	}
  
}
