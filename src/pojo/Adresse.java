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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "adresse", catalog = "librairie")
public class Adresse implements Serializable {
	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name = "idAdresse", unique = true, nullable = false)
	private Integer idAdresse = 0;
	@Column(name = "rue", nullable = false, length = 100)
	private String rue = null;
	@Column(name = "numero", nullable = false, length = 10)
	private String numero = null;
	@Column(name = "codePostal", nullable = false, length = 10)
	private String codePostal = null;
	@Column(name = "localite", nullable = false, length = 50)
	private String localite = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "pays_idPays", nullable = false)
	private Pays pays = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "adresse")
	private Set<Personne> personnes = new HashSet<Personne>(0);
	// private Edition edition = null;
	// private Fournisseur fournisseur = null;
  
   	public Adresse() {
  		
  	}
	
	public Integer getIdAdresse() {
		return idAdresse;
	}	
	public void setIdAdresse(Integer idAdresse) {
		this.idAdresse = idAdresse;
	}
		
	public String getRue() {
		return rue;
	}	
	public void setRue(String rue) {
		this.rue = rue;
	}	
	
	public String getNumero() {
		return numero;
	}	
	public void setNumero(String numero) {
		this.numero = numero;
	}	
	
	public String getCodePostal() {
		return codePostal;
	}	
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}	
	
	public String getLocalite() {
		return localite;
	}	
	public void setLocalite(String localite) {
		this.localite = localite;
	}	

	public Pays getPays() {
		return pays;
	}	
	public void setPays(Pays pays) {
		this.pays = pays;
	}	
	
	public Set<Personne> getPersonnes() {
		return personnes;
	}	
	public void setPersonnes(Set<Personne> personnes) {
		this.personnes = personnes;
	}
	/*
	@OneToOne	
	public Edition getEdition() {
		return edition;
	}
	
	public void setEdition(Edition edition) {
		this.edition = edition;
	}
	
	OneToOne
	public Fournisseur getFournisseur() {
		return fournisseur;
	}
	
	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}
	*/
}
