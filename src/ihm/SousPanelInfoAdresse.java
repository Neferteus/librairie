package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Date;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import connexion.HibernateUtil;
import pojo.Adresse;
import pojo.Client;
import pojo.Pays;

public class SousPanelInfoAdresse extends JPanel {
	private List<Pays> lstPays = null;
	
	private GridBagConstraints gbc = null;
	private JLabel lblRue = null;
	private JLabel lblNumero = null;
	private JLabel lblCp = null;
	private JLabel lblLocalite = null;
	private JLabel lblPays = null;
	private JTextField txtRue = null;
	private JTextField txtNumero = null;
	private JTextField txtCp = null;
	private JTextField txtLocalite = null;
	private JComboBox<String> txtPays = null;
	
	public SousPanelInfoAdresse(){
		super();
		build();
	}

	private void build() {
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		this.setBorder(BorderFactory.createTitledBorder(null, "Adresse", TitledBorder.DEFAULT_JUSTIFICATION, 
				TitledBorder.DEFAULT_POSITION, new Font("Verdana", 2, 14), Color.BLUE));
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets(10, 10, 10, 10);
		lblRue = new JLabel("Rue");
		lblRue.setPreferredSize(new Dimension(100, 20));
		this.add(lblRue, gbc);
		
		gbc.gridx = 1;
		txtRue = new JTextField();
		txtRue.setPreferredSize(new Dimension(400, 20));
		this.add(txtRue, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lblNumero = new JLabel("Numero");
		lblNumero.setPreferredSize(new Dimension(100, 20));
		this.add(lblNumero, gbc);
		
		gbc.gridx = 1;
		txtNumero = new JTextField();
		txtNumero.setPreferredSize(new Dimension(400, 20));
		this.add(txtNumero, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		lblCp = new JLabel("Code Postal");
		lblCp.setPreferredSize(new Dimension(100, 20));
		this.add(lblCp, gbc);
		
		gbc.gridx = 1;
		txtCp = new JTextField();
		txtCp.setPreferredSize(new Dimension(400, 20));
		this.add(txtCp, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 3;
		lblLocalite = new JLabel("Localité");
		lblLocalite.setPreferredSize(new Dimension(100, 20));
		this.add(lblLocalite, gbc);
		
		gbc.gridx = 1;
		txtLocalite = new JTextField();
		txtLocalite.setPreferredSize(new Dimension(400, 20));
		this.add(txtLocalite, gbc);	
		
		gbc.gridx = 0;
		gbc.gridy = 4;
		lblPays = new JLabel("Pays");
		lblPays.setPreferredSize(new Dimension(100, 20));
		this.add(lblPays, gbc);
		
		gbc.gridx = 1;
		txtPays = new JComboBox<String>();
		txtPays.setPreferredSize(new Dimension(400, 20));
		Session session = HibernateUtil.instance().openSession();
		lstPays = session.createCriteria(Pays.class).list();
		for(Pays p : lstPays){
			txtPays.addItem(p.getNomPays());
		}		
		txtPays.setSelectedIndex(-1);
		this.add(txtPays, gbc);
	}
	
	public boolean verificationChamp(){
		boolean flag = true;
		
		if(txtRue.getText().trim().length() == 0){
			lblRue.setForeground(Color.RED);
			flag = false;
		}else{
			lblRue.setForeground(Color.BLACK);
		}
		
		if(txtNumero.getText().trim().length() == 0 ){
			lblNumero.setForeground(Color.RED);
			flag = false;			
		}else{
			lblNumero.setForeground(Color.BLACK);
		}
		
		if(txtCp.getText().trim().length() == 0){
			lblCp.setForeground(Color.RED);
			flag = false;
		}else{
			lblCp.setForeground(Color.BLACK);
		}
		
		if(txtLocalite.getText().trim().length() == 0){
			lblLocalite.setForeground(Color.RED);
			flag = false;
		}else{
			lblLocalite.setForeground(Color.BLACK);
		}
		if( txtPays.getSelectedIndex() < 0){
			lblPays.setForeground(Color.RED);
			flag = false;
		}else{
			lblPays.setForeground(Color.BLACK);
		}
		return flag;
	}
	
	private boolean verificationDonnees(){
		if(txtRue.getText().trim().length() > 100){
			JOptionPane.showMessageDialog(null, "La rue peut contenir maximum 100 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtNumero.getText().trim().length() > 10 ){
			JOptionPane.showMessageDialog(null, "Le numero peut contenir maximum 10 caractères !", "Attention", 1);
			return false;		
		}
		
		if(txtCp.getText().trim().length() > 10){
			JOptionPane.showMessageDialog(null, "Le code postal peut contenir maximum 10 caractères !", "Attention", 1);
			return false;
		}
		
		if(txtLocalite.getText().trim().length() > 50){
			JOptionPane.showMessageDialog(null, "La localité peut contenir maximum 50 caractères !", "Attention", 1);
			return false;
		}
		
		return true;
	}
	
	public int validationDonnee(){
		Session session = null;
		Transaction tx = null;
		Adresse adresse = null;
		Pays pays = null;
		
		session = HibernateUtil.instance().openSession();		
		adresse = new Adresse();
		pays = new Pays();
		try{
			tx = session.beginTransaction();
			pays = (Pays) session.createCriteria(Pays.class)
					.add(Restrictions.eq("nomPays", txtPays.getSelectedItem().toString()))
					.uniqueResult();
			
			adresse.setRue( txtRue.getText() );
			adresse.setNumero( txtNumero.getText() );
			adresse.setCodePostal( txtCp.getText() );
			adresse.setLocalite( txtLocalite.getText() );
			adresse.setPays(pays);
			session.persist(adresse);
			
			tx.commit();
		}
		catch (HibernateException e1) {
			if (tx != null) tx.rollback();
			e1.printStackTrace(); 
		}
		finally {
			session.close(); 
		}
		return adresse.getIdAdresse();
	}
	
	public void remiseZero(){
		lblRue.setForeground(Color.BLACK);
		txtRue.setText(null);
		lblNumero.setForeground(Color.BLACK);
		txtNumero.setText(null);
		lblCp.setForeground(Color.BLACK);
		txtCp.setText(null);
		lblLocalite.setForeground(Color.BLACK);
		txtLocalite.setText(null);
		lblPays.setForeground(Color.BLACK);
		txtPays.setSelectedIndex(-1);
	}

}
