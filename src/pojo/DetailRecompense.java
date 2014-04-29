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
@Table(name = "detailRecompense", catalog = "librairie")
public class DetailRecompense implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailRecompense", unique = true, nullable = false)
	private Integer idDetailRecompense = 0;
	@Column(name = "annee", nullable = false)
	private int annee = 0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auteur_idAuteur", nullable = false)
	private Auteur auteur;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailRecompense_recompense", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "detailRecompense_idDetailRecompense", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "recompense_idRecompense", nullable = false, updatable = false)
	})
	private Set<Recompense> recompenses = new HashSet<Recompense>(0);  
	
	public DetailRecompense(){
		
	}

	public Integer getIdDetailRecompense() {
		return idDetailRecompense;
	}

	public void setIdDetailRecompense(Integer idDetailRecompense) {
		this.idDetailRecompense = idDetailRecompense;
	}

	public int getAnnee() {
		return annee;
	}

	public void setAnnee(int annee) {
		this.annee = annee;
	}

	public Auteur getAuteur() {
		return auteur;
	}

	public void setAuteur(Auteur auteur) {
		this.auteur = auteur;
	}

	public Set<Recompense> getRecompenses() {
		return recompenses;
	}

	public void setRecompenses(Set<Recompense> recompenses) {
		this.recompenses = recompenses;
	}

}
