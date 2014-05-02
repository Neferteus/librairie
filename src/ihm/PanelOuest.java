package ihm;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import listener.panelOuestListener;

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
		this.setBackground(Color.WHITE);
		
		btnAccueil = new JButton("Accueil");
		btnAccueil.addActionListener(new panelOuestListener(0));
		this.add(btnAccueil);
		
		btnVente = new JButton("Vente");
		btnVente.addActionListener(new panelOuestListener(1));
		this.add(btnVente);
		
		btnAchat = new JButton("Achat");
		btnAchat.setEnabled(responsable);
		btnAchat.addActionListener(new panelOuestListener(2));
		this.add(btnAchat);
		
		btnClient = new JButton("Client");
		btnClient.addActionListener(new panelOuestListener(3));
		this.add(btnClient);
		
		btnFournisseur = new JButton("Fournisseur");
		btnFournisseur.setEnabled(responsable);
		btnFournisseur.addActionListener(new panelOuestListener(4));
		this.add(btnFournisseur);
		
		btnLivre = new JButton("Livre");
		btnLivre.addActionListener(new panelOuestListener(5));
		this.add(btnLivre);
		
		btnVendeur = new JButton("Vendeur");
		btnVendeur.setEnabled(responsable);
		btnVendeur.addActionListener(new panelOuestListener(6));
		this.add(btnVendeur);
	}
	
}
