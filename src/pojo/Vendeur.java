package pojo;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;


@Entity
@Table(name = "vendeur", catalog = "librairie", uniqueConstraints = @UniqueConstraint(columnNames =  {"login", "password"}))
@AttributeOverrides({
	@AttributeOverride(name="nomPersonne", column=@Column(name="nomPersonne")),
	@AttributeOverride(name="prenomPersonne", column=@Column(name="prenomPersonne")),
	@AttributeOverride(name="telephonePersonne", column=@Column(name="telephonePersonne")),
	@AttributeOverride(name="emailPersonne", column=@Column(name="emailPersonne")),
	@AttributeOverride(name="dateNaissancePersonne", column=@Column(name="dateNaissancePersonne")),
	@AttributeOverride(name="sexePersonne", column=@Column(name="sexePersonne"))
})

public class Vendeur extends Personne implements Serializable {
	/*
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "personne"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "idVendeur", unique = true, nullable = false)
	private Integer idVendeur = 0;
	*/
	@Column (name = "login", nullable = false, length = 12)
	private String login = null;	
	@Column (name = "password", nullable = false, length = 44) // Ca dependra du cryptage utilisé (Pour SHA1, length  = 44, MD5 length = 32)
	private String password = null;
	@Column(name = "responsable", nullable = false)
	private byte responsable = 0;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendeur")
	private Set<NoteCredit> noteCredits = new HashSet<NoteCredit>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendeur")
	private Set<Commande> commandes = new HashSet<Commande>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "vendeur")
	private Set<Vente> ventes = new HashSet<Vente>(0);

	public Vendeur(){
		
	}
/*
	public Integer getIdVendeur() {
		return idVendeur;
	}
	public void setIdVendeur(Integer idVendeur) {
		this.idVendeur = idVendeur;
	}
*/
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public byte getResponsable() {
		return responsable;
	}
	public void setResponsable(byte responsable) {
		this.responsable = responsable;
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

	public Set<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(Set<Vente> ventes) {
		this.ventes = ventes;
	}
	
}
