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
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "detailVente", catalog = "librairie")
public class DetailVente implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailVente", unique = true, nullable = false)
	private Integer idDetailVente = 0;
	@Column(name = "quantiteVente", nullable = false)
	private int quantiteVente = 0;
	@Column(name = "prixVenteReelHtva", nullable = false, precision = 22, scale = 0)
	private double prixVenteReelHtva;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livre_idLivre", nullable = false)
	private Livre livre = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "vente_detailVente", catalog = "librairie", joinColumns = {			
			@JoinColumn(name = "detailVente_idDetailVente", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "vente_idVente", nullable = false, updatable = false)
	})
	private Set<Vente> ventes = new HashSet<Vente>(0);
	
	public DetailVente(){
		
	}

	public Integer getIdDetailVente() {
		return idDetailVente;
	}

	public void setIdDetailVente(Integer idDetailVente) {
		this.idDetailVente = idDetailVente;
	}

	public int getQuantiteVente() {
		return quantiteVente;
	}

	public void setQuantiteVente(int quantiteVente) {
		this.quantiteVente = quantiteVente;
	}

	public double getPrixVenteReelHtva() {
		return prixVenteReelHtva;
	}

	public void setPrixVenteReelHtva(double prixVenteReelHtva) {
		this.prixVenteReelHtva = prixVenteReelHtva;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Set<Vente> getVentes() {
		return ventes;
	}

	public void setVentes(Set<Vente> ventes) {
		this.ventes = ventes;
	}

	@Override
	public String toString() {
		return "DetailVente [idDetailVente=" + idDetailVente
				+ ", quantiteVente=" + quantiteVente + ", prixVenteReelHtva="
				+ prixVenteReelHtva + ", livre=" + livre + ", ventes=" + ventes
				+ "]";
	}
		
}
