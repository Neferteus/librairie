package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "paiement", catalog = "librairie")
public class Paiement implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPaiement", unique = true, nullable = false)
	private Integer idPaiement = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "datePaiement", nullable = false)
	private Date datePaiement;
	@Column(name = "montantVerse", nullable = false, precision = 22, scale = 0)
	private double montantVerse = 0.0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "facture_idFacture", nullable = false)
	private Facture facture = null;

	public Paiement(){
		
	}

	public Integer getIdPaiement() {
		return idPaiement;
	}

	public void setIdPaiement(Integer idPaiement) {
		this.idPaiement = idPaiement;
	}

	public Date getDatePaiement() {
		return datePaiement;
	}

	public void setDatePaiement(Date datePaiement) {
		this.datePaiement = datePaiement;
	}

	public double getMontantVerse() {
		return montantVerse;
	}

	public void setMontantVerse(double montantVerse) {
		this.montantVerse = montantVerse;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
}
