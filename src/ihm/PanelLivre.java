package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.TitledBorder;

import listener.PanelClientListener;
import model.ModelTextField;

import org.hibernate.Session;

import connexion.HibernateUtil;
import pojo.Auteur;
import pojo.Collection;
import pojo.Edition;
import pojo.Format;
import pojo.Genre;

public class PanelLivre extends JPanel {
	Session session = null;
	private List<Genre> lstGenre = null;
	private List<Format> lstFormat = null;
	private List<Auteur> lstAuteur = null;
	private List<Edition> lstEdition = null;
	private List<Collection> lstCollection = null;
	private GridBagConstraints gbc = null;
	private JPanel pnlBouton = null;
	private JLabel lblInfo = null;
	private JLabel lblIsbn = null;
	private JLabel lblTitre = null;
	private JLabel lblSousTitre = null;
	private JLabel lblAnnee = null;
	private JLabel lblGenre = null;
	private JLabel lblFormat = null;
	private JLabel lblAuteur = null;
	private JLabel lblEdition = null;
	private JLabel lblCollection = null;
	private JLabel lblDescription = null;
	private JLabel lblPrixAchatHtva = null;
	private JLabel lblPrixVenteHtva = null;
	private JLabel lblStock = null;
	private JLabel lblSeuilMinimal = null;
	private JTextField txtIsbn = null;
	private JTextField txtTitre = null;
	private JTextField txtSousTitre = null;
	private JTextField txtAnnee = null;
	private JTextArea txtDescription = null;
	private JTextField txtPrixAchatHtva = null;
	private JTextField txtPrixVenteHtva = null;
	private JTextField txtStock = null;
	private JTextField txtSeuilMinimal = null;
	private JComboBox<String> comboGenre = null;
	private JComboBox<String> comboFormat = null;
	private JComboBox<String> comboAuteur = null;
	private JComboBox<String> comboEdition = null;
	private JComboBox<String> comboCollection = null;
	private JButton btnGenre = null;
	private JButton btnFormat = null;
	private JButton btnAuteur = null;
	private JButton btnEdition = null;
	private JButton btnCollection = null;
	private JButton btnRechercher = null;
	private JButton btnEnregistrer = null;
	private JButton btnAnnuler = null;
	private JScrollPane scrollDescription = null;
	
	public PanelLivre() {
		super();
		build();
	}

	private void build() {
		session = HibernateUtil.instance().openSession();
		this.setBackground(Color.WHITE);
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		gbc.gridwidth = 3;		
		lblInfo = new JLabel("Les champs accompagnés d'un * sont obligatoires.");
		lblInfo.setFont(new Font("Verdana", 2, 12));
		lblInfo.setPreferredSize(new Dimension(500, 20));
		lblInfo.setHorizontalAlignment(JLabel.CENTER);
		this.add(lblInfo, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;	
		gbc.gridwidth = 1;
		lblIsbn = new JLabel("Code ISBN*");
		lblIsbn.setPreferredSize(new Dimension(100, 20));
		this.add(lblIsbn, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtIsbn = new JTextField();
		txtIsbn.setPreferredSize(new Dimension(400, 20));
		this.add(txtIsbn, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 1;
		lblTitre = new JLabel("Titre*");
		lblTitre.setPreferredSize(new Dimension(100, 20));
		this.add(lblTitre, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtTitre = new JTextField();
		txtTitre.setPreferredSize(new Dimension(400, 20));
		this.add(txtTitre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		gbc.gridwidth = 1;
		lblSousTitre = new JLabel("Sous-Titre");
		lblSousTitre.setPreferredSize(new Dimension(100, 20));
		this.add(lblSousTitre, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtSousTitre = new JTextField();
		txtSousTitre.setPreferredSize(new Dimension(400, 20));
		this.add(txtSousTitre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		gbc.gridwidth = 1;
		lblAnnee = new JLabel("Année de sortie*");
		lblAnnee.setPreferredSize(new Dimension(100, 20));
		this.add(lblAnnee, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtAnnee = new JTextField();
		txtAnnee.setPreferredSize(new Dimension(400, 20));
		this.add(txtAnnee, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		gbc.gridwidth = 1;
		lblGenre = new JLabel("Genre*");
		lblGenre.setPreferredSize(new Dimension(100, 20));
		this.add(lblGenre, gbc);
		
		gbc.gridx = 1;
		comboGenre = new JComboBox<String>();
		comboGenre.setPreferredSize(new Dimension(250, 20));
		lstGenre = session.createQuery("FROM Genre ORDER BY nomGenre").list();
		for (Genre g : lstGenre){
			comboGenre.addItem(g.getNomGenre());
		}
		comboGenre.setSelectedIndex(-1);
		this.add(comboGenre, gbc);
		
		gbc.gridx = 2;
		btnGenre = new JButton("Gérer Genre");
		btnGenre.setPreferredSize(new Dimension(130, 20));
		this.add(btnGenre, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		lblFormat = new JLabel("Format*");
		lblFormat.setPreferredSize(new Dimension(100, 20));
		this.add(lblFormat, gbc);
		
		gbc.gridx = 1;
		comboFormat = new JComboBox<String>();
		comboFormat.setPreferredSize(new Dimension(250, 20));
		lstFormat = session.createQuery("FROM Format ORDER BY nomFormat").list();
		for (Format f : lstFormat){
			comboFormat.addItem(f.getNomFormat());
		}
		comboFormat.setSelectedIndex(-1);
		this.add(comboFormat, gbc);
		
		gbc.gridx = 2;
		btnFormat = new JButton("Gérer Format");
		btnFormat.setPreferredSize(new Dimension(130, 20));
		this.add(btnFormat, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		lblAuteur = new JLabel("Auteur*");
		lblAuteur.setPreferredSize(new Dimension(100, 20));
		this.add(lblAuteur, gbc);
		
		gbc.gridx = 1;
		comboAuteur = new JComboBox<String>();
		comboAuteur.setPreferredSize(new Dimension(250, 20));
		lstAuteur = session.createQuery("FROM Auteur ORDER BY nomAuteur, prenomAuteur").list();
		for (Auteur a : lstAuteur){
			comboAuteur.addItem(a.getNomAuteur().concat(" ").concat(a.getPrenomAuteur()));
		}
		comboAuteur.setSelectedIndex(-1);
		this.add(comboAuteur, gbc);
		
		gbc.gridx = 2;
		btnAuteur = new JButton("Gérer Auteur");
		btnAuteur.setPreferredSize(new Dimension(130, 20));
		this.add(btnAuteur, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		lblEdition = new JLabel("Edition*");
		lblEdition.setPreferredSize(new Dimension(100, 20));
		this.add(lblEdition, gbc);
		
		gbc.gridx = 1;
		comboEdition = new JComboBox<String>();
		comboEdition.setPreferredSize(new Dimension(250, 20));
		lstEdition = session.createQuery("FROM Edition ORDER BY nomEdition").list();
		for (Edition e : lstEdition){
			comboEdition.addItem(e.getNomEdition());
		}
		comboEdition.setSelectedIndex(-1);
		this.add(comboEdition, gbc);
		
		gbc.gridx = 2;
		btnEdition = new JButton("Gérer Edition");
		btnEdition.setPreferredSize(new Dimension(130, 20));
		this.add(btnEdition, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		lblCollection = new JLabel("Collection");
		lblCollection.setPreferredSize(new Dimension(100, 20));
		this.add(lblCollection, gbc);
		
		gbc.gridx = 1;
		comboCollection = new JComboBox<String>();
		comboCollection.setPreferredSize(new Dimension(250, 20));
		lstCollection = session.createQuery("FROM Collection ORDER BY nomCollection").list();
		for (Collection c : lstCollection){
			comboCollection.addItem(c.getNomCollection());
		}
		comboCollection.setSelectedIndex(-1);
		this.add(comboCollection, gbc);
		
		gbc.gridx = 2;
		btnCollection = new JButton("Gérer Collection");
		btnCollection.setPreferredSize(new Dimension(130, 20));
		this.add(btnCollection, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 10;
		lblDescription = new JLabel("Description*");
		lblDescription.setPreferredSize(new Dimension(100, 20));
		this.add(lblDescription, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 11;
		gbc.gridwidth = 3;
		gbc.gridheight = 4;
		txtDescription = new JTextArea();
		txtDescription.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		scrollDescription = new JScrollPane();
		scrollDescription.setViewportView(txtDescription);
		scrollDescription.setPreferredSize(new Dimension(500, 80));
		this.add(scrollDescription, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 15;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		lblPrixAchatHtva = new JLabel("Prix Achat Htva*");
		lblPrixAchatHtva.setPreferredSize(new Dimension(100, 20));
		this.add(lblPrixAchatHtva, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtPrixAchatHtva = new JTextField();
		txtPrixAchatHtva.setPreferredSize(new Dimension(400, 20));
		this.add(txtPrixAchatHtva, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 16;
		gbc.gridwidth = 1;
		lblPrixVenteHtva = new JLabel("Prix Vente Htva*");
		lblPrixVenteHtva.setPreferredSize(new Dimension(100, 20));
		this.add(lblPrixVenteHtva, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtPrixVenteHtva = new JTextField();
		txtPrixVenteHtva.setPreferredSize(new Dimension(400, 20));
		this.add(txtPrixVenteHtva, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 17;
		gbc.gridwidth = 1;
		lblStock = new JLabel("Stock*");
		lblStock.setPreferredSize(new Dimension(100, 20));
		this.add(lblStock, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtStock = new JTextField();
		txtStock.setPreferredSize(new Dimension(400, 20));
		this.add(txtStock, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 18;
		gbc.gridwidth = 1;
		lblSeuilMinimal = new JLabel("Seuil minimal*");
		lblSeuilMinimal.setPreferredSize(new Dimension(100, 20));
		this.add(lblSeuilMinimal, gbc);
		
		gbc.gridx = 1;
		gbc.gridwidth = 2;
		txtSeuilMinimal = new JTextField();
		txtSeuilMinimal.setPreferredSize(new Dimension(400, 20));
		this.add(txtSeuilMinimal, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 19;
		gbc.gridwidth = 3;
		pnlBouton = new JPanel();
		btnRechercher = new JButton("Rechercher");
		//btnRechercher.addActionListener();
		pnlBouton.add(btnRechercher);
		btnEnregistrer = new JButton("Enregistrer");
		//btnEnregistrer.addActionListener();
		pnlBouton.add(btnEnregistrer);
		btnAnnuler = new JButton("Annuler");
		//btnAnnuler.addActionListener();
		pnlBouton.add(btnAnnuler);
		pnlBouton.setBackground(Color.WHITE);
		this.add(pnlBouton, gbc);
	}

	// Vérifier que tous les champs sont différents de vide
	public boolean verificationChamp(){
		if (txtIsbn.getText().trim().length() == 0){
			return false;
		}
		
		if (txtTitre.getText().trim().length() == 0){
			return false;
		}
		
		if (txtAnnee.getText().trim().length() == 0){
			return false;
		}
		
		
		
		if (txtDescription.getText().trim().length() == 0){
			return false;
		}
		
		if (txtPrixAchatHtva.getText().trim().length() == 0){
			return false;
		}
		
		if (txtPrixVenteHtva.getText().trim().length() == 0){
			return false;
		}
		
		if (txtStock.getText().trim().length() == 0){
			return false;
		}
		
		if (txtSeuilMinimal.getText().trim().length() == 0){
			return false;
		}
		
		return true;
	}
}
