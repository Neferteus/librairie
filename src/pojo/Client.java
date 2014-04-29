package pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "client", catalog = "librairie")
@AttributeOverrides({
	@AttributeOverride(name="nomPersonne", column=@Column(name="nomPersonne")),
	@AttributeOverride(name="prenomPersonne", column=@Column(name="prenomPersonne")),
	@AttributeOverride(name="telephonePersonne", column=@Column(name="telephonePersonne")),
	@AttributeOverride(name="emailPersonne", column=@Column(name="emailPersonne")),
	@AttributeOverride(name="dateNaissancePersonne", column=@Column(name="dateNaissancePersonne")),
	@AttributeOverride(name="sexePersonne", column=@Column(name="sexePersonne"))
})
public class Client extends Personne implements Serializable {
	/*
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "idVendeur", unique = true, nullable = false)
	private Integer idClient = 0;
	*/
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "client")	
	private Set<Remise> remises = new HashSet<Remise>(0);
	@OneToMany(fetch= FetchType.LAZY, mappedBy = "client")
	private Set<Vente> ventes = new HashSet<Vente>(0);  

	public Client(){
		
	}
/*
	public Integer getIdClient() {
		return idClient;
	}
	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}
*/
	public Set<Remise> getRemises() {
		return remises;
	}
	public void setRemises(Set<Remise> remises) {
		this.remises = remises;
	}

	public Set<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(Set<Vente> ventes) {
		this.ventes = ventes;
	}
	
}
