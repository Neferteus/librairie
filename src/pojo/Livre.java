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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "livre", catalog = "librairie")
public class Livre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idLivre", unique = true, nullable = false)
	private Integer idLivre = 0;
	@Column(name = "isbn", unique = true, nullable = false)
	private long isbn;
	@Column(name = "titre", nullable = false, length = 100)
	private String titre = null;
	@Column(name = "sousTitre", nullable = true, length = 100)
	private String sousTitre = null;
	@Temporal(TemporalType.DATE)
	@Column(name = "anneeSortie", nullable = false)
	private Date anneeSortie;
	@Column(name = "description", nullable = false, length = 65535)
	private String description = null;
	@Column(name = "prixAchatActuelHtva", nullable = false, precision = 22, scale = 0)
	private double prixAchatActuelHtva = 0.0;
	@Column(name = "prixVenteHtva", nullable = false, precision = 22, scale = 0)
	private double prixVenteHtva = 0.0;
	@Column(name = "stock", nullable = false)
	private int stock = 0;
	@Column(name = "seuilMin", nullable = false)
	private int seuilMin = 0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "format_idFormat", nullable = false)
	private Format format = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "edition_idEdition", nullable = false)
	private Edition edition = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livre_auteur", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "livre_idLivre", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "auteur_idAuteur", nullable = false, updatable = false)
	})
	private Set<Auteur> auteurs = new HashSet<Auteur>(0);
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "livre_genre", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "livre_idLivre", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "genre_idGenre", nullable = false, updatable = false)
	})
	private Set<Genre> genres = new HashSet<Genre>(0);
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "collection_idCollection", nullable = true)
	private Collection collection = null;	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
	private Set<DetailVente> detailVentes = new HashSet<DetailVente>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
	private Set<DetailNoteCredit> detailNoteCredits = new HashSet<DetailNoteCredit>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
	private Set<DetailCommande> detailCommandes = new HashSet<DetailCommande>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "livre")
	private Set<DetailLivraison> detailLivraisons = new HashSet<DetailLivraison>(0);
	
	public Livre(){
		
	}

	public Integer getIdLivre() {
		return idLivre;
	}

	public void setIdLivre(Integer idLivre) {
		this.idLivre = idLivre;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getSousTitre() {
		return sousTitre;
	}

	public void setSousTitre(String sousTitre) {
		this.sousTitre = sousTitre;
	}

	public Date getAnneeSortie() {
		return anneeSortie;
	}

	public void setAnneeSortie(Date anneeSortie) {
		this.anneeSortie = anneeSortie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrixAchatActuelHtva() {
		return prixAchatActuelHtva;
	}

	public void setPrixAchatActuelHtva(double prixAchatActuelHtva) {
		this.prixAchatActuelHtva = prixAchatActuelHtva;
	}

	public double getPrixVenteHtva() {
		return prixVenteHtva;
	}

	public void setPrixVenteHtva(double prixVenteHtva) {
		this.prixVenteHtva = prixVenteHtva;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public int getSeuilMin() {
		return seuilMin;
	}

	public void setSeuilMin(int seuilMin) {
		this.seuilMin = seuilMin;
	}

	public Format getFormat() {
		return format;
	}

	public void setFormat(Format format) {
		this.format = format;
	}

	public Edition getEdition() {
		return edition;
	}

	public void setEdition(Edition edition) {
		this.edition = edition;
	}

	public Set<Auteur> getAuteurs() {
		return auteurs;
	}

	public void setAuteurs(Set<Auteur> auteurs) {
		this.auteurs = auteurs;
	}

	public Set<Genre> getGenres() {
		return genres;
	}

	public void setGenres(Set<Genre> genres) {
		this.genres = genres;
	}

	public Collection getCollection() {
		return collection;
	}

	public void setCollection(Collection collection) {
		this.collection = collection;
	}

	public Set<DetailVente> getDetailVentes() {
		return detailVentes;
	}

	public void setDetailVentes(Set<DetailVente> detailVentes) {
		this.detailVentes = detailVentes;
	}

	public Set<DetailNoteCredit> getDetailNoteCredits() {
		return detailNoteCredits;
	}

	public void setDetailNoteCredits(Set<DetailNoteCredit> detailNoteCredits) {
		this.detailNoteCredits = detailNoteCredits;
	}

	public Set<DetailCommande> getDetailCommandes() {
		return detailCommandes;
	}

	public void setDetailCommandes(Set<DetailCommande> detailCommandes) {
		this.detailCommandes = detailCommandes;
	}

	public Set<DetailLivraison> getDetailLivraisons() {
		return detailLivraisons;
	}

	public void setDetailLivraisons(Set<DetailLivraison> detailLivraisons) {
		this.detailLivraisons = detailLivraisons;
	}
	
}
