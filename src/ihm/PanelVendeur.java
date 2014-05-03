package ihm;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import listener.PanelClientListener;
import listener.PanelVendeurListener;

public class PanelVendeur extends JPanel {
	private GridBagConstraints gbc = null;
	private JPanel pnlInfoPerso = null;
	private JPanel pnlAdresse = null;
	private JPanel pnlBouton = null;
	private JButton btnRechercher = null;
	private JButton btnEnregistrer = null;
	private JButton btnAnnuler = null;
	
	public PanelVendeur() {
		super();
		build();
	}

	private void build() {
		this.setLayout(new GridBagLayout());
		this.setBackground(Color.WHITE);
		gbc = new GridBagConstraints();
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		pnlInfoPerso = new SousPanelInfoPersonnel(true);
		this.add(pnlInfoPerso, gbc);
		
		gbc.gridy = 1;
		pnlAdresse = new SousPanelInfoAdresse();
		this.add(pnlAdresse, gbc);
		
		gbc.gridy = 2;
		pnlBouton = new JPanel();
		btnRechercher = new JButton("Rechercher");
		btnRechercher.addActionListener(new PanelVendeurListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnRechercher);
		
		btnEnregistrer = new JButton("Enregistrer");
		btnEnregistrer.addActionListener(new PanelVendeurListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnEnregistrer);
		
		btnAnnuler = new JButton("Annuler");
		btnAnnuler.addActionListener(new PanelVendeurListener(pnlInfoPerso, pnlAdresse));
		pnlBouton.add(btnAnnuler);
		pnlBouton.setBackground(Color.WHITE);
		this.add(pnlBouton, gbc);
	}
}
