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
@Table(name = "detailLivraison", catalog = "librairie")
public class DetailLivraison implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailLivraison", unique = true, nullable = false)
	private Integer idDetailLivraison = 0;
	@Column(name = "quantiteLivraison", nullable = false)
	private int quantiteLivraison = 0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livre_idLivre", nullable = false)
	private Livre livre; 
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailLivraison_livraison", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "detailLivraison_idDetailLivraison", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "livraison_idLivraison", nullable = false, updatable = false)
	})
	private Set<Livraison> livraisons = new HashSet<Livraison>(0);  

	public DetailLivraison(){
		
	}

	public Integer getIdDetailLivraison() {
		return idDetailLivraison;
	}

	public void setIdDetailLivraison(Integer idDetailLivraison) {
		this.idDetailLivraison = idDetailLivraison;
	}

	public int getQuantiteLivraison() {
		return quantiteLivraison;
	}

	public void setQuantiteLivraison(int quantiteLivraison) {
		this.quantiteLivraison = quantiteLivraison;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Set<Livraison> getLivraisons() {
		return livraisons;
	}

	public void setLivraisons(Set<Livraison> livraisons) {
		this.livraisons = livraisons;
	}
	
}
