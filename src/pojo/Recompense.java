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
import javax.persistence.Table;


@Entity
@Table(name = "recompense", catalog = "librairie")
public class Recompense implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idRecompense", unique = true, nullable = false)
	private Integer idRecompense = 0;
	@Column(name = "nomRecompense", nullable = false, length = 50)
	private String nomRecompense = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailRecompense_recompense", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "recompense_idRecompense", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "detailRecompense_idDetailRecompense", nullable = false, updatable = false)
	})
	private Set<DetailRecompense> detailRecompenses = new HashSet<DetailRecompense>(0);

	public Recompense(){
		
	}

	public Integer getIdRecompense() {
		return idRecompense;
	}

	public void setIdRecompense(Integer idRecompense) {
		this.idRecompense = idRecompense;
	}

	public String getNomRecompense() {
		return nomRecompense;
	}

	public void setNomRecompense(String nomRecompense) {
		this.nomRecompense = nomRecompense;
	}

	public Set<DetailRecompense> getDetailRecompenses() {
		return detailRecompenses;
	}

	public void setDetailRecompenses(Set<DetailRecompense> detailRecompenses) {
		this.detailRecompenses = detailRecompenses;
	}
	
}
