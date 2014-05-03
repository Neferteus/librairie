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
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "recompense_idRecompense", nullable = false)
	private Recompense recompense;  
	
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

	public Recompense getRecompense() {
		return recompense;
	}
	
	public void setRecompense(Recompense recompense) {
		this.recompense = recompense;
	}
	
}
