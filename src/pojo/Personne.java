package pojo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name = "personne", catalog = "librairie")
public class Personne implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "CUSTOMER_ID")
	@TableGenerator(
			name = "CUSTOMER_ID", table = "counterIdPersonne", 
			pkColumnName = "CounterName", valueColumnName = "CounterValue", 
			pkColumnValue = "CUSTOMER_NO", initialValue = 1, allocationSize = 1) 
	@Column(name = "id", nullable = false)
	protected Integer idPersonne = 0;
	@Column(name = "nomPersonne", nullable = false, length = 50)
	protected String nomPersonne = null;
	@Column(name = "prenomPersonne", nullable = false, length = 50)
	protected String prenomPersonne = null;
	@Column(name = "telephonePersonne", nullable = false, length = 20)
	protected String telephonePersonne = null;
	@Column(name = "emailPersonne", unique = true, nullable = false, length = 100)
	protected String emailPersonne = null;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateNaissancePersonne", nullable = false)
	protected Date dateNaissancePersonne;
	@Column(name = "sexePersonne", nullable = false, length = 1)
	protected char sexePersonne;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "adresse_idAdresse", nullable = false)
	private Adresse adresse = null;
	
	public Personne(){
		
	}

	public Integer getIdPersonne() {
		return idPersonne;
	}
	
	public void setIdPersonne(Integer idPersonne) {
		this.idPersonne = idPersonne;
	}
	
	public String getNomPersonne() {
		return nomPersonne;
	}
	
	public void setNomPersonne(String nomPersonne) {
		this.nomPersonne = nomPersonne;
	}
	
	public String getPrenomPersonne() {
		return prenomPersonne;
	}
	
	public void setPrenomPersonne(String prenomPersonne) {
		this.prenomPersonne = prenomPersonne;
	}
	
	public String getTelephonePersonne() {
		return telephonePersonne;
	}
	
	public void setTelephonePersonne(String telephone) {
		this.telephonePersonne = telephone;
	}
	
	public String getEmailPersonne() {
		return emailPersonne;
	}
	
	public void setEmailPersonne(String email) {
		this.emailPersonne = email;
	}
	
	public Date getDateNaissancePersonne() {
		return dateNaissancePersonne;
	}
	
	public void setDateNaissancePersonne(Date dateNaissance) {
		this.dateNaissancePersonne = dateNaissance;
	}
	
	public char getSexePersonne() {
		return sexePersonne;
	}
	
	public void setSexePersonne(char sexe) {
		this.sexePersonne = sexe;
	}
	
	public Adresse getAdresse() {
		return adresse;
	}
	
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
  
}
