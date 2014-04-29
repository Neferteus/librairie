package listener;

import ihm.DialogConnexion;
import ihm.FenetrePrincipal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import org.hibernate.Session;

import pojo.Vendeur;
import test.HibernateUtil;

public class DialogConnexionListener implements ActionListener {
	private JDialog dialogConnexion = null;
	
	public DialogConnexionListener(JDialog dialogConnexion){
		this.dialogConnexion = dialogConnexion;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Valider")){
			if(((DialogConnexion) dialogConnexion).rechercheVendeur() == 1)
			FenetrePrincipal.setResponsable(true);
		}
		
		if (ae.getActionCommand().equals("Quitter")){
			System.exit(0);
		}
	}

}
