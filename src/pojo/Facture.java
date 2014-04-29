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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "facture", catalog = "librairie")
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFacture", unique = true, nullable = false)
	private Integer idFacture = 0;
	@Column(name = "nrFacture", nullable = false, length = 50)
	private String nrFacture = null;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateFacture", nullable = false)
	private Date dateFacture;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseur_idFournisseur", nullable = false)
	private Fournisseur fournisseur = null;  
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	private Set<Livraison> livraisons = new HashSet<Livraison>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "facture")
	private Set<Paiement> paiements = new HashSet<Paiement>(0);  
	
	public Facture(){
		
	}

	public Integer getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Integer idFacture) {
		this.idFacture = idFacture;
	}

	public String getNrFacture() {
		return nrFacture;
	}

	public void setNrFacture(String nrFacture) {
		this.nrFacture = nrFacture;
	}

	public Date getDateFacture() {
		return dateFacture;
	}

	public void setDateFacture(Date dateFacture) {
		this.dateFacture = dateFacture;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}

	public Set<Paiement> getPaiements() {
		return paiements;
	}

	public void setPaiements(Set<Paiement> paiements) {
		this.paiements = paiements;
	}

	public double retourPrix() {
		return 0.0;
	}

}
