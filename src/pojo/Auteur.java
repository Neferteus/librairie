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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "auteur", catalog = "librairie")
public class Auteur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAuteur", unique = true, nullable = false)
	private Integer idAuteur = 0;
	@Column(name = "nomAuteur", nullable = false, length = 50)
	private String nomAuteur = null;
	@Column(name = "prenomAuteur", nullable = false, length = 50)
	private String prenomAuteur = null;
	@Column(name = "email", nullable = false, length = 100)
	private String email = null;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissance", nullable = false)
	private Date dateNaissance;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateDeces", nullable = true)
	private Date dateDeces;
  	@ManyToMany(fetch = FetchType.LAZY)
  		@JoinTable(name = "livre_auteur", catalog = "librairie", joinColumns = {
  			@JoinColumn(name = "auteur_idAuteur", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "livre_idLivre", nullable = false, updatable = false)
			
	})
  	private Set<Livre> livres = new HashSet<Livre>(0);
  	@OneToMany(fetch = FetchType.LAZY, mappedBy = "auteur")
  	private Set<DetailRecompense> detailRecompenses = new HashSet<DetailRecompense>(0);

  	public Auteur(){
  		
  	}

	public Integer getIdAuteur() {
		return idAuteur;
	}

	public void setIdAuteur(Integer idAuteur) {
		this.idAuteur = idAuteur;
	}

	public String getNomAuteur() {
		return nomAuteur;
	}

	public void setNomAuteur(String nomAuteur) {
		this.nomAuteur = nomAuteur;
	}

	public String getPrenomAuteur() {
		return prenomAuteur;
	}

	public void setPrenomAuteur(String prenomAuteur) {
		this.prenomAuteur = prenomAuteur;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Date getDateDeces() {
		return dateDeces;
	}

	public void setDateDeces(Date dateDeces) {
		this.dateDeces = dateDeces;
	}

	public Set<Livre> getLivres() {
		return livres;
	}

	public void setLivres(Set<Livre> livres) {
		this.livres = livres;
	}

	public Set<DetailRecompense> getDetailRecompenses() {
		return detailRecompenses;
	}

	public void setDetailRecompenses(Set<DetailRecompense> detailRecompenses) {
		this.detailRecompenses = detailRecompenses;
	}
  	
}
