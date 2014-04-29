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
@Table(name = "detailNoteCredit", catalog = "librairie")
public class DetailNoteCredit implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idDetailNoteCredit", unique = true, nullable = false)
	private Integer idDetailNoteCredit = 0;
	@Column(name = "quantiteNoteCredit", nullable = false)
  	private int quantiteNoteCredit = 0;
	@Column(name = "prixHtva", nullable = false, precision = 22, scale = 0)
  	private double prixHtva = 0.0;
  	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "livre_idLivre", nullable = true)
  	private Livre livre = null;
  	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "detailNoteCredit_noteCredit", catalog = "librairie", joinColumns = {
			@JoinColumn(name = "detailNoteCredit_idDetailNoteCredit", nullable = false, updatable = false) }, inverseJoinColumns = {
			@JoinColumn(name = "noteCredit_idNoteCredit", nullable = false, updatable = false)
	})
  	private Set<NoteCredit> noteCredits = new HashSet<NoteCredit>(0);

  	public DetailNoteCredit(){
  		
  	}

	public Integer getIdDetailNoteCredit() {
		return idDetailNoteCredit;
	}

	public void setIdDetailNoteCredit(Integer idDetailNoteCredit) {
		this.idDetailNoteCredit = idDetailNoteCredit;
	}

	public int getQuantiteNoteCredit() {
		return quantiteNoteCredit;
	}

	public void setQuantiteNoteCredit(int quantiteNoteCredit) {
		this.quantiteNoteCredit = quantiteNoteCredit;
	}

	public double getPrixHtva() {
		return prixHtva;
	}

	public void setPrixHtva(double prixHtva) {
		this.prixHtva = prixHtva;
	}

	public Livre getLivre() {
		return livre;
	}

	public void setLivre(Livre livre) {
		this.livre = livre;
	}

	public Set<NoteCredit> getNoteCredits() {
		return noteCredits;
	}

	public void setNoteCredits(Set<NoteCredit> noteCredits) {
		this.noteCredits = noteCredits;
	}
	
}
