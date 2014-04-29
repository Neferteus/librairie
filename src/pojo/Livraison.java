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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "livraison", catalog = "librairie")
public class Livraison implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLivraison", unique = true, nullable = false)
	private Integer idLivraison = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateLivraison", nullable = false)
	private Date dateLivraison;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facture_idFacture", nullable = false)
	private Facture facture = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailLivraison_livraison", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "livraison_idLivraison", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "detailLivraison_idDetailLivraison", nullable = false, updatable = false)
	})
	private Set<DetailLivraison> detailsLivraisons = new HashSet<DetailLivraison>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livraison_commande", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "livraison_idLivraison", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "commande_idCommande", nullable = false, updatable = false)
	})
	private Set<Commande> commandes = new HashSet<Commande>(0);
	
	public Livraison(){
		
	}

	public Integer getIdLivraison() {
		return idLivraison;
	}

	public void setIdLivraison(Integer idLivraison) {
		this.idLivraison = idLivraison;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Set<DetailLivraison> getDetailsLivraisons() {
		return detailsLivraisons;
	}

	public void setDetailsLivraisons(Set<DetailLivraison> detailsLivraisons) {
		this.detailsLivraisons = detailsLivraisons;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
