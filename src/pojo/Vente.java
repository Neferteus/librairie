package pojo;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "vente", catalog = "librairie")
public class Vente implements Serializable {
	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name = "idVente", unique = true, nullable = false)
	private Integer idVente = 0;
	@Column(name = "nrVente", nullable = false, length = 50)
	private String nrVente = null;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateVente", nullable = false)
	private Date dateVente;
	@Column(name = "modePaiement", nullable = false, length = 1)
	private char modePaiement;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_idClient", nullable = false)
	private Client client = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendeur_idVendeur", nullable = false)
	private Vendeur vendeur = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vente_detailVente", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "vente_idVente", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "detailVente_idDetailVente", nullable = false, updatable = false)
	})
	private Set<DetailVente> detailVentes = new HashSet<DetailVente>(0);

	public Vente(){
		
	}

	public Integer getIdVente() {
		return idVente;
	}

	public void setIdVente(Integer idVente) {
		this.idVente = idVente;
	}

	public String getNrVente() {
		return nrVente;
	}

	public void setNrVente(String nrVente) {
		this.nrVente = nrVente;
	}

	public Date getDateVente() {
		return dateVente;
	}

	public void setDateVente(Date dateVente) {
		this.dateVente = dateVente;
	}

	public char getModePaiement() {
		return modePaiement;
	}

	public void setModePaiement(char modePaiement) {
		this.modePaiement = modePaiement;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Set<DetailVente> getDetailVentes() {
		return detailVentes;
	}

	public void setDetailVentes(Set<DetailVente> detailVentes) {
		this.detailVentes = detailVentes;
	}
	
}
