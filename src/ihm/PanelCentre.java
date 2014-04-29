package ihm;

import java.awt.CardLayout;

import javax.swing.JPanel;

/**
 * @author Ludovic
 *
 */
public class PanelCentre extends JPanel {	
	private String[] contenu = {"carte1", "carte2", "carte3", "carte4", "carte5", "carte6","carte7"};	
	private CardLayout cl = null;
	
	public PanelCentre() {
		super();
		build();
	}

	private void build() {
		cl = new CardLayout();
		this.setLayout(cl);
		
		this.add(new PanelAccueil(), contenu[0]);
		this.add(new PanelVente(), contenu[1]);
		this.add(new PanelAchat(), contenu[2]);
		this.add(new PanelClient(), contenu[3]);
		this.add(new PanelFournisseur(), contenu[4]);
		this.add(new PanelLivre(), contenu[5]);
		this.add(new PanelVendeur(), contenu[6]);
		
		cl.show(this, contenu[0]);
	}

	public void changeContenu(int i){
		cl.show(this, contenu[i]);
	}
	
	public void remiseZero(){
		this.add(new PanelAccueil(), contenu[0]);
		this.add(new PanelVente(), contenu[1]);
		this.add(new PanelAchat(), contenu[2]);
		this.add(new PanelClient(), contenu[3]);
		this.add(new PanelFournisseur(), contenu[4]);
		this.add(new PanelLivre(), contenu[5]);
		this.add(new PanelVendeur(), contenu[6]);
	}
		
}
