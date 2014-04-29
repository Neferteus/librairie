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
@Table(name = "remise", catalog = "librairie")
public class Remise implements Serializable {
	@Id
  	@GeneratedValue(strategy = GenerationType.IDENTITY)
  	@Column(name = "idRemise", unique = true, nullable = false)
	private Integer idRemise = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateDebutRemise", nullable = false)
	private Date dateDebutRemise;
	@Column(name = "nbrAchat", nullable = false)
	private int nbrAchat = 0;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateFinRemise", nullable = false)
	private Date dateFinRemise;
	@Temporal(TemporalType.DATE)
	@Column(name = "dateRemise", nullable = false)
	private Date dateRemise;
	@Column(name = "montantRemise", nullable = false, precision = 22, scale = 0)
	private double montantRemise = 0.0;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "client_idClient", nullable = false)
	private Client client = null;

}
