package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import listener.PanelClientListener;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import pojo.Client;
import test.HibernateUtil;

public class PanelClient extends JPanel {
	private JPanel panel = null;
	private GridBagConstraints gbc = null;
	private JPanel pnlInfoPerso = null;
	private JPanel pnlAdresse = null;
	private JPanel pnlInfoLogin = null;
	private JPanel pnlBouton = null;
	private JButton btnRechercher = null;
	private JButton btnEnregistrer = null;
	private JButton btnAnnuler = null;	
	
	public PanelClient() {
		super();
		this.panel = this;
		build();
	}

	private void build() {
		gbc = new GridBagConstraints();
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlInfoPerso = new SousPanelInfoPersonnel(false);
		this.add(pnlInfoPerso,gbc);
		
		gbc.gridy = 1;
		pnlAdresse = new SousPanelInfoAdresse();
		this.add(pnlAdresse, gbc);
		
		gbc.gridy = 2;
		pnlBouton = new JPanel();
		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new PanelClientListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnRechercher);
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new PanelClientListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnEnregistrer);
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new PanelClientListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnAnnuler);
		pnlBouton.setBackground(Color.WHITE);
		this.add(pnlBouton, gbc);
	}
	
}
