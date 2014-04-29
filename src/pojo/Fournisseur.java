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
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "fournisseur", catalog = "librairie")
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idFournisseur", unique = true, nullable = false)
	private Integer idFournisseur = 0;
	@Column(name = "nomFournisseur", nullable = false, length = 50)
	private String nomFournisseur = null;
	@Column(name = "formeJuridique", nullable = false, length = 20)
	private String formeJuridique = null;
	@Column(name = "nrTva", nullable = false, length = 20)
	private String nrTva = null;
	@Column(name = "telephone", nullable = false, length = 20)
	private String telephone = null;
	@Column(name = "fax", nullable = false, length = 20)
	private String fax = null;
	@Column(name = "email", unique = true, nullable = false, length = 100)
	private String email = null;
	@OneToOne
	@JoinColumn(name = "fournisseur_idAdresse", referencedColumnName = "idAdresse")
	private Adresse adresse = null;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
	private Set<NoteCredit> noteCredits = new HashSet<NoteCredit>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
	private Set<Commande> commandes = new HashSet<Commande>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fournisseur")
	private Set<Facture> factures = new HashSet<Facture>(0);

	public Fournisseur(){
		
	}

	public Integer getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(Integer idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

	public String getNomFournisseur() {
		return nomFournisseur;
	}

	public void setNomFournisseur(String nomFournisseur) {
		this.nomFournisseur = nomFournisseur;
	}

	public String getFormeJuridique() {
		return formeJuridique;
	}

	public void setFormeJuridique(String formeJuridique) {
		this.formeJuridique = formeJuridique;
	}

	public String getNrTva() {
		return nrTva;
	}

	public void setNrTva(String nrTva) {
		this.nrTva = nrTva;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<NoteCredit> getNoteCredits() {
		return noteCredits;
	}

	public void setNoteCredits(Set<NoteCredit> noteCredits) {
		this.noteCredits = noteCredits;
	}

	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}

	public Set<Facture> getFactures() {
		return factures;
	}

	public void setFactures(Set<Facture> factures) {
		this.factures = factures;
	}
	
}
