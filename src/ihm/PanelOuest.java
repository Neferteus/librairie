package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import model.BoutonPanelOuest;

public class PanelOuest extends JPanel {
	private boolean responsable = false;
	private JPanel panel = null;	
	private GridLayout gl = null;		
	private JButton btnAccueil = null;
	private JButton btnVente = null;
	private JButton btnAchat = null;
	private JButton btnClient = null;
	private JButton btnFournisseur = null;
	private JButton btnLivre = null;
	private JButton btnVendeur = null;
	
	public PanelOuest(JPanel panel, boolean responsable){
		super();
		this.panel = panel;
		this.responsable = responsable;
		build();
	}

	private void build() {
		gl = new GridLayout(7, 1, 10, 10);
		this.setLayout(gl);
		this.setBackground(Color.DARK_GRAY);
		
		btnAccueil = new BoutonPanelOuest("Accueil","images/livre.gif", 0);
		this.add(btnAccueil);
		
		btnAchat = new BoutonPanelOuest("Achat","images/livre.gif", 2);
		btnAchat.setEnabled(responsable);
		btnAchat.setVisible(responsable);
		this.add(btnAchat);
		
		btnVente = new BoutonPanelOuest("Vente","images/livre.gif", 1);
		this.add(btnVente);

		btnFournisseur = new BoutonPanelOuest("Fournisseur","images/livre.gif", 4);
		btnFournisseur.setEnabled(responsable);
		btnFournisseur.setVisible(responsable);
		this.add(btnFournisseur);
		
		btnClient = new BoutonPanelOuest("Client","images/livre.gif", 3);
		this.add(btnClient);
		
		btnVendeur = new BoutonPanelOuest("Vendeur","images/livre.gif", 6);
		btnVendeur.setEnabled(responsable);
		btnVendeur.setVisible(responsable);
		this.add(btnVendeur);
		
		btnLivre = new BoutonPanelOuest("Livre","images/livre.gif", 5);
		this.add(btnLivre);

	}
	
}
