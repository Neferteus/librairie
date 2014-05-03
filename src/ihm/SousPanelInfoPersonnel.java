package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connexion.HibernateUtil;
import outil.CryptageMdP;
import pojo.Adresse;
import pojo.Client;
import pojo.Vendeur;

public class SousPanelInfoPersonnel extends JPanel{
	private boolean actif = false;		

	private GridBagConstraints gbc = null;
	private JLabel lblSexe = null;
	private JLabel lblNom = null;
	private JLabel lblPrenom = null;
	private JLabel lblTelephone = null;
	private JLabel lblEmail = null;	
	private JLabel lblDateNaissance = null;
	private JRadioButton homme = null; 
	private JRadioButton femme = null;
	private ButtonGroup bgSexe = null;
	private JPanel panSexe = null; 
	private JTextField txtNom = null;
	private JTextField txtPrenom = null;	
	private JTextField txtTelephone = null;
	private JTextField txtEmail = null;
	private JTextField txtDateNaissance = null;

	private JLabel lblLogin = null;
	private JLabel lblMotDePasse = null;
	private JLabel lblMotDePasse2 = null;
	private JLabel lblResponsable = null;
	private JTextField txtLogin = null;
	private JPasswordField txtMotDePasse = null;
	private JPasswordField txtMotDePasse2 = null;
	private JRadioButton jrdOui = null; 
	private JRadioButton jrdNon = null;
	private ButtonGroup bgResponsable = null;
	private JPanel pnlResponsable = null;
	
	// Le boolean sert à savoir si la personne est un vendeur et donc activer les champs login et password qui lui sont liés
	public SousPanelInfoPersonnel(boolean actif){
		super();
		this.actif = actif;
		build();
	}
	
	private void build() {
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Informations personnelles", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("Verdana", 2, 14), Color.BLUE));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		lblSexe = new JLabel("Sexe");
		lblSexe.setPreferredSize(new Dimension(100, 20));
		this.add(lblSexe, gbc);
		
		gbc.gridx = 1;
		homme = new JRadioButton("Homme");
		homme.setBackground(Color.WHITE);
		femme = new JRadioButton("Femme");
		femme.setBackground(Color.WHITE);
		bgSexe = new ButtonGroup();		
		bgSexe.add(homme);
		bgSexe.add(femme);
		panSexe = new JPanel();
		panSexe.setBackground(Color.WHITE);
		panSexe.add(homme);
		panSexe.add(femme);
		this.add(panSexe, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;		
		lblNom = new JLabel("Nom");
		lblNom.setPreferredSize(new Dimension(100, 20));
		this.add(lblNom, gbc);
		
		gbc.gridx = 1;
		txtNom = new JTextField();
		txtNom.setPreferredSize(new Dimension(400, 20));
		this.add(txtNom, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lblPrenom = new JLabel("Prenom");
		lblPrenom.setPreferredSize(new Dimension(100, 20));
		this.add(lblPrenom, gbc);
		
		gbc.gridx = 1;
		txtPrenom = new JTextField();
		txtPrenom.setPreferredSize(new Dimension(400, 20));
		this.add(txtPrenom, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		lblTelephone = new JLabel("Telephone");
		lblTelephone.setPreferredSize(new Dimension(100, 20));
		this.add(lblTelephone, gbc);
		
		gbc.gridx = 1;
		txtTelephone = new JTextField();
		txtTelephone.setPreferredSize(new Dimension(400, 20));
		this.add(txtTelephone, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		lblEmail = new JLabel("e-mail");
		lblEmail.setPreferredSize(new Dimension(100, 20));
		this.add(lblEmail, gbc);
		
		gbc.gridx = 1;
		txtEmail = new JTextField();
		txtEmail.setPreferredSize(new Dimension(400, 20));
		this.add(txtEmail, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 5;
		lblDateNaissance = new JLabel("Date de naissance");
		lblDateNaissance.setPreferredSize(new Dimension(100, 20));
		this.add(lblDateNaissance, gbc);
		
		gbc.gridx = 1;
		txtDateNaissance = new JTextField();
		txtDateNaissance.setPreferredSize(new Dimension(400, 20));
		this.add(txtDateNaissance, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 6;
		lblLogin = new JLabel("Login");
		lblLogin.setPreferredSize(new Dimension(100, 20));
		lblLogin.setEnabled(actif);
		this.add(lblLogin, gbc);
		
		gbc.gridx = 1;
		txtLogin = new JTextField();
		txtLogin.setPreferredSize(new Dimension(400, 20));
		txtLogin.setEnabled(actif);
		this.add(txtLogin, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 7;
		lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setPreferredSize(new Dimension(100, 20));
		lblMotDePasse.setEnabled(actif);
		this.add(lblMotDePasse, gbc);
		
		gbc.gridx = 1;
		txtMotDePasse = new JPasswordField();
		txtMotDePasse.setPreferredSize(new Dimension(400, 20));
		txtMotDePasse.setEnabled(actif);
		this.add(txtMotDePasse, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 8;
		lblMotDePasse2 = new JLabel("Veuillez confirmer");
		lblMotDePasse2.setPreferredSize(new Dimension(100, 20));
		lblMotDePasse2.setEnabled(actif);
		this.add(lblMotDePasse2, gbc);
		
		gbc.gridx = 1;
		txtMotDePasse2 = new JPasswordField();
		txtMotDePasse2.setPreferredSize(new Dimension(400, 20));
		txtMotDePasse2.setEnabled(actif);
		this.add(txtMotDePasse2, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 9;
		lblResponsable = new JLabel("Responsable");
		lblResponsable.setPreferredSize(new Dimension(100, 20));
		lblResponsable.setEnabled(actif);
		this.add(lblResponsable, gbc);
		
		gbc.gridx = 1;
		jrdOui = new JRadioButton("Oui");
		jrdOui.setBackground(Color.WHITE);
		jrdOui.setEnabled(actif);
		jrdNon = new JRadioButton("Non");
		jrdNon.setBackground(Color.WHITE);
		jrdNon.setEnabled(actif);
		bgResponsable = new ButtonGroup();		
		bgResponsable.add(jrdOui);
		bgResponsable.add(jrdNon);
		pnlResponsable = new JPanel();
		pnlResponsable.setBackground(Color.WHITE);
		pnlResponsable.add(jrdOui);
		pnlResponsable.add(jrdNon);
		this.add(pnlResponsable, gbc);
		
		this.setEnabled(actif);
	}

	// Vérifier que tous les champs sont différents de vide
	public boolean verificationChamp(){
		boolean flag = true;
		
		if(bgSexe.isSelected(null)){
			lblSexe.setForeground(Color.RED);
			flag = false;
		}else{
			lblSexe.setForeground(Color.BLACK);
		}
		
		if(txtNom.getText().trim().length() == 0){
			lblNom.setForeground(Color.RED);
			flag = false;
		}else{
			lblNom.setForeground(Color.BLACK);
		}
		
		if(txtPrenom.getText().trim().length() == 0){
			lblPrenom.setForeground(Color.RED);
			flag = false;			
		}else{
			lblPrenom.setForeground(Color.BLACK);
		}
		
		if(txtTelephone.getText().trim().length() == 0){
			lblTelephone.setForeground(Color.RED);
			flag = false;
		}else{
			lblTelephone.setForeground(Color.BLACK);
		}
		
		if(txtEmail.getText().trim().length() == 0){
			lblEmail.setForeground(Color.RED);
			flag = false;
		}else{
			lblEmail.setForeground(Color.BLACK);
		}
		
		if(txtDateNaissance.getText().trim().length() == 0){
			lblDateNaissance.setForeground(Color.RED);
			flag = false;
		}else{
			lblDateNaissance.setForeground(Color.BLACK);
		}
		
		if(txtLogin.isEnabled()){
			if(txtLogin.getText().trim().length() == 0){
				lblLogin.setForeground(Color.RED);
				flag = false;
			}else{
				lblLogin.setForeground(Color.BLACK);
			}
		}
		
		if(txtMotDePasse.isEnabled()){
			if(txtMotDePasse.getPassword().length == 0){
				lblMotDePasse.setForeground(Color.RED);
				flag = false;
			}else{
				lblMotDePasse.setForeground(Color.BLACK);
			}
		}
		
		if(txtMotDePasse2.isEnabled()){
			if(txtMotDePasse2.getPassword().length == 0){
				lblMotDePasse2.setForeground(Color.RED);
				flag = false;
			}else{
				lblMotDePasse2.setForeground(Color.BLACK);
			}
		}
		
		if(jrdOui.isEnabled()){
			if(bgResponsable.isSelected(null)){
				lblResponsable.setForeground(Color.RED);
				flag = false;
			}else{
				lblResponsable.setForeground(Color.BLACK);
			}
		}
		
		return flag;
	}

	// Vérifier que tous les champs ne dépassent pas les limites de la DB
	public boolean verificationDonnees(){
		if(txtNom.getText().trim().length() > 50){
			JOptionPane.showMessageDialog(null, "Le nom peut contenir maximum 50 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtPrenom.getText().trim().length() > 50){
			JOptionPane.showMessageDialog(null, "Le prénom peut contenir maximum 50 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtTelephone.getText().trim().length() > 20){
			JOptionPane.showMessageDialog(null, "Le téléphone peut contenir maximum 20 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtEmail.getText().trim().length() > 100){
			JOptionPane.showMessageDialog(null, "L'adresse mail peut contenir maximum 100 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtLogin.isEnabled()){
			if(txtLogin.getText().trim().length() > 12){
				JOptionPane.showMessageDialog(null, "Le login peut contenir maximum 12 caractères !", "Attention", 1);
				return false;
			}
		}
		
		if(txtMotDePasse.isEnabled()){
			if(txtMotDePasse.getPassword().equals(lblMotDePasse2)){
				JOptionPane.showMessageDialog(null, "Entrez 2 fois le même mot de passe !", "Attention", 1);
			}
		}
		
		return true;
	}

	// Vérifier que l'email n'est pas encore sauvegardé dans la DB
	public boolean verificationEmail(){
		List<Client> clients = null;
		List<Vendeur> vendeurs = null;
		Session session = HibernateUtil.instance().openSession();	

		clients = session.createQuery("FROM Client").list();
		vendeurs = session.createQuery("FROM Vendeur").list();
		
		for(Vendeur v : vendeurs){
			if(txtEmail.getText().trim().equalsIgnoreCase(v.getEmailPersonne())){
				return false;
			}
		}
		
		for(Client c : clients){
			if(txtEmail.getText().trim().equalsIgnoreCase(c.getEmailPersonne())){
				return false;
			}
		}
		
		return true;
	}

	// Enregistrer les données dans la DB pour le client
	public void validationDonneeClient(Integer idAdresse){
		Session session = null;
		Transaction tx = null;
		Client client = null;
		
		session = HibernateUtil.instance().openSession();
		client = new Client();
		try{
			tx = session.beginTransaction();
			
			client.setNomPersonne( txtNom.getText() );
			client.setPrenomPersonne( txtPrenom.getText() );
			client.setTelephonePersonne( txtTelephone.getText() );
			client.setEmailPersonne( txtEmail.getText() );
			client.setDateNaissancePersonne( new Date() );
			client.setAdresse( (Adresse) session.get(Adresse.class, new Integer(idAdresse)) );
			if ( homme.isSelected() ) client.setSexePersonne('H');
			if ( femme.isSelected() ) client.setSexePersonne('F');
			
			session.persist(client);
			
			tx.commit();
		}
		catch (HibernateException e1) {
			if (tx != null) tx.rollback();
			e1.printStackTrace(); 
		}
		finally {
			session.close(); 
		}
	}

	// Enregistrer les données dans la DB pour le vendeur
	public void validationDonneeVendeur(Integer idAdresse){
		String pwTmp = null;
		byte[] byteTmp = null;	
		Vendeur vendeur = null;		
		Session session = null;
		Transaction tx = null;
		
		session = HibernateUtil.instance().openSession();		
		vendeur = new Vendeur();
		try{
			tx = session.beginTransaction();
			
			vendeur.setNomPersonne( txtNom.getText() );
			vendeur.setPrenomPersonne( txtPrenom.getText() );
			vendeur.setTelephonePersonne( txtTelephone.getText() );
			vendeur.setEmailPersonne( txtEmail.getText() );
			vendeur.setDateNaissancePersonne( new Date() );			
			if ( homme.isSelected() ) vendeur.setSexePersonne('H');
			if ( femme.isSelected() ) vendeur.setSexePersonne('F');
			vendeur.setLogin(txtLogin.getText());
			pwTmp = new String(txtMotDePasse.getPassword());
			pwTmp = CryptageMdP.passToString(CryptageMdP.encoderMotDePasse(pwTmp));			
			vendeur.setPassword(pwTmp);
			if (jrdOui.isSelected()) vendeur.setResponsable((byte) 1);
			if (jrdNon.isSelected()) vendeur.setResponsable((byte) 0);
			vendeur.setAdresse( (Adresse) session.get(Adresse.class, new Integer(idAdresse)) );
			session.persist(vendeur);
			
			tx.commit();
		}
		catch (HibernateException e1) {
			if (tx != null) tx.rollback();
			e1.printStackTrace(); 
		}
		finally {
			session.close(); 
		}
	}

	// RaZ des champs
	public void remiseZero(){
		lblSexe.setForeground(Color.BLACK);
		bgSexe.clearSelection();
		lblNom.setForeground(Color.BLACK);
		txtNom.setText(null);
		lblPrenom.setForeground(Color.BLACK);
		txtPrenom.setText(null);
		lblTelephone.setForeground(Color.BLACK);
		txtTelephone.setText(null);
		lblEmail.setForeground(Color.BLACK);
		txtEmail.setText(null);
		lblDateNaissance.setForeground(Color.BLACK);
		txtDateNaissance.setText(null);
		lblLogin.setForeground(Color.BLACK);
		txtLogin.setText(null);
		lblMotDePasse.setForeground(Color.BLACK);
		txtMotDePasse.setText(null);
		lblMotDePasse2.setForeground(Color.BLACK);
		txtMotDePasse2.setText(null);
		lblResponsable.setForeground(Color.BLACK);
		bgResponsable.clearSelection();
	}

	public JTextField getTxtNom() {
		return txtNom;
	}

}
