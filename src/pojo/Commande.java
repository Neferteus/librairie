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
@Table(name = "commande", catalog = "librairie")
public class Commande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCommande", unique = true, nullable = false)
	private Integer idCommande = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateCommande", nullable = false)
	private Date dateCommande;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateLivraisonDemande", nullable = false)
	private Date dateLivraisonDemande;
	@Column(name = "statut", nullable = false, length = 1)
	private char statut;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseur_idFournisseur", nullable = false)
	private Fournisseur fournisseur = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendeur_idVendeur", nullable = false)
	private Vendeur vendeur = null;  
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailCommande_commande", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "commande_idCommande", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "detailCommande_idDetailCommande", nullable = false, updatable = false)
	})
	private Set<DetailCommande> detailCommandes = new HashSet<DetailCommande>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livraison_commande", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "commande_idCommande", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "livraison_idLivraison", nullable = false, updatable = false)
	})
	private Set<Livraison> livraisons = new HashSet<Livraison>(0);
	
	public Commande(){
		
	}

	public Integer getIdCommande() {
		return idCommande;
	}

	public void setIdCommande(Integer idCommande) {
		this.idCommande = idCommande;
	}

	public Date getDateCommande() {
		return dateCommande;
	}

	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}

	public Date getDateLivraisonDemande() {
		return dateLivraisonDemande;
	}

	public void setDateLivraisonDemande(Date dateLivraisonDemande) {
		this.dateLivraisonDemande = dateLivraisonDemande;
	}

	public char getStatut() {
		return statut;
	}

	public void setStatut(char statut) {
		this.statut = statut;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Set<DetailCommande> getDetailCommandes() {
		return detailCommandes;
	}

	public void setDetailCommandes(Set<DetailCommande> detailCommandes) {
		this.detailCommandes = detailCommandes;
	}

	public Set<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
}
