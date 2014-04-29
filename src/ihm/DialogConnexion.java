package ihm;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import listener.DialogConnexionListener;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import outil.CryptageMdP;
import pojo.Pays;
import pojo.Vendeur;
import test.HibernateUtil;

public class DialogConnexion extends JDialog {
	private Session session = HibernateUtil.instance().openSession();
	private GridBagConstraints gbc = null;
	private JPanel pnlBouton = null;
	private JLabel lblLogin = null;
	private JLabel lblMotDePasse = null;
	private JTextField txtLogin	= null;
	private JPasswordField txtMotDePasse = null;
	private JButton btnValider = null;
	private JButton btnQuitter = null;
	
	public DialogConnexion(){
		super();
		build();
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});
		
		this.setTitle("Connexion à la Base de données");
		this.setLayout(new GridBagLayout());
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.insets = new Insets (10,10,10,10);
		lblLogin = new JLabel("Login : ");
		lblLogin.setPreferredSize(new Dimension(100, 20));
		this.add(lblLogin, gbc);
		
		gbc.gridx = 1;
		txtLogin = new JTextField();
		txtLogin.setPreferredSize(new Dimension(200, 20));
		this.add(txtLogin, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		lblMotDePasse = new JLabel("Mot de passe : ");
		lblMotDePasse.setPreferredSize(new Dimension(100, 20));
		this.add(lblMotDePasse, gbc);
		
		gbc.gridx = 1;
		txtMotDePasse = new JPasswordField();
		txtMotDePasse.setPreferredSize(new Dimension(200, 20));
		this.add(txtMotDePasse, gbc);
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.gridwidth = 2;
		pnlBouton = new JPanel();
		pnlBouton.setPreferredSize(new Dimension(300, 30));
		btnValider = new JButton("Valider");
		btnValider.addActionListener(new DialogConnexionListener(this));
		btnQuitter = new JButton("Quitter");
		btnQuitter.addActionListener(new DialogConnexionListener(this));
		pnlBouton.add(btnValider);
		pnlBouton.add(btnQuitter);
		this.add(pnlBouton, gbc);
		
		this.setModalityType(ModalityType.APPLICATION_MODAL);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
	public void confirmation(){
		Vendeur vendeur = new Vendeur();
		Transaction tx = null;
		tx = session.beginTransaction();
		session.createQuery("");
		tx.commit();
	}
	
	public byte rechercheVendeur(){
		String pwTmp = null;
		
		Vendeur vendeur = null;
		vendeur = new Vendeur();
		Transaction tx = null;
		try{
			tx = session.beginTransaction();
			
			pwTmp = new String(txtMotDePasse.getPassword());
			pwTmp = CryptageMdP.passToString(CryptageMdP.encoderMotDePasse(pwTmp));
			
			vendeur = (Vendeur) session.createQuery("FROM Vendeur WHERE login = ? AND password = ?")
					.setString(0, txtLogin.getText()).setString(1, pwTmp).uniqueResult();
			
			tx.commit();
		}
		catch (HibernateException e1) {
			if (tx != null) tx.rollback();
			e1.printStackTrace(); 
		}
		
		if(vendeur != null){
			this.dispose();
		}else{
			JOptionPane.showMessageDialog(null, "Login et/ou password invalide !");
		}
		if (vendeur != null){
			return vendeur.getResponsable();
		}else{
			return 0;
		}
		
	}

}
