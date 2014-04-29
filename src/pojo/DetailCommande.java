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
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "detailCommande", catalog = "librairie")
public class DetailCommande implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailCommande", unique = true, nullable = false)
	private Integer idDetailCommande = 0;
	@Column(name = "quantiteCommande", nullable = false)
	private int quantiteCommande = 0;
	@Column(name = "prixAchatReelHtva", nullable = false, precision = 22, scale = 0)
	private double prixAchatReelHtva = 0.0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livre_idLivre", nullable = false)
	private Livre livre = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailCommande_commande", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "detailCommande_idDetailCommande", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "commande_idCommande", nullable = false, updatable = false)
	})
	private Set<Commande> commandes = new HashSet<Commande>(0); 

	public DetailCommande(){
		
	}

	public Integer getIdDetailCommande() {
		return idDetailCommande;
	}

	public void setIdDetailCommande(Integer idDetailCommande) {
		this.idDetailCommande = idDetailCommande;
	}

	public int getQuantiteCommande() {
		return quantiteCommande;
	}

	public void setQuantiteCommande(int quantiteCommande) {
		this.quantiteCommande = quantiteCommande;
	}

	public double getPrixAchatReelHtva() {
		return prixAchatReelHtva;
	}

	public void setPrixAchatReelHtva(double prixAchatReelHtva) {
		this.prixAchatReelHtva = prixAchatReelHtva;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}
	void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	
}
