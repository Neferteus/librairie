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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "noteCredit", catalog = "librairie")
class NoteCredit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idNoteCredit", unique = true, nullable = false)
	private Integer idNoteCredit = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateNoteCredit", nullable = false)
	private Date dateNoteCredit;
	@Column(name = "defectueux", nullable = false)
	private byte defectueux = 0;
	@Column(name = "invendu", nullable = false)
	private byte invendu = 0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendeur_idVendeur", nullable = false)
	private Vendeur vendeur = null;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "fournisseur_idFournisseur", nullable = false)
	private Fournisseur fournisseur = null;
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailNoteCredit_noteCredit", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "noteCredit_idNoteCredit", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "detailNoteCredit_idDetailNoteCredit", nullable = false, updatable = false)
	})
	private Set<DetailNoteCredit> detailNoteCredits = new HashSet<DetailNoteCredit>(0);

	public NoteCredit(){
		
	}

	public Integer getIdNoteCredit() {
		return idNoteCredit;
	}

	public void setIdNoteCredit(Integer idNoteCredit) {
		this.idNoteCredit = idNoteCredit;
	}

	public Date getDateNoteCredit() {
		return dateNoteCredit;
	}

	public void setDateNoteCredit(Date dateNoteCredit) {
		this.dateNoteCredit = dateNoteCredit;
	}

	public byte getDefectueux() {
		return defectueux;
	}

	public void setDefectueux(byte defectueux) {
		this.defectueux = defectueux;
	}

	public byte getInvendu() {
		return invendu;
	}

	public void setInvendu(byte invendu) {
		this.invendu = invendu;
	}

	public Vendeur getVendeur() {
		return vendeur;
	}

	public void setVendeur(Vendeur vendeur) {
		this.vendeur = vendeur;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Set<DetailNoteCredit> getDetailNoteCredits() {
		return detailNoteCredits;
	}

	public void setDetailNoteCredits(Set<DetailNoteCredit> detailNoteCredits) {
		this.detailNoteCredits = detailNoteCredits;
	}
	
}
