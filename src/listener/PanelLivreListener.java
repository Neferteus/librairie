package listener;

import ihm.DialogGenre;
import ihm.PanelLivre;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelLivreListener implements ActionListener {
	private JPanel pnlLivre = null;
	private JDialog dialog = null;
	
	public PanelLivreListener(JPanel pnlLivre){
		super();
		this.pnlLivre = pnlLivre;
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Gérer Genre")){
			dialog = new DialogGenre();
		}
		
		if (ae.getActionCommand().equals("Gérer Format")){
					
		}
		
		if (ae.getActionCommand().equals("Gérer Auteur")){
			
		}
		
		if (ae.getActionCommand().equals("Gérer Edition")){
			
		}
		
		if (ae.getActionCommand().equals("Gérer Collection")){
			
		}
		
		if (ae.getActionCommand().equals("Rechercher")){
			
		}
		
		if (ae.getActionCommand().equals("Enregistrer")){
			if ( ((PanelLivre)pnlLivre).verificationChamp() ){
				
			}else{
				JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs accompagnés d'un *");
			}
		}
		
		if (ae.getActionCommand().equals("Annuler")){
			
		}
	}

}
