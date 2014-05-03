package listener;

import ihm.DialogRecherche;
import ihm.SousPanelInfoAdresse;
import ihm.SousPanelInfoPersonnel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import connexion.HibernateUtil;
import pojo.Client;
import pojo.Vendeur;

public class PanelVendeurListener implements ActionListener {
	private JPanel pnlInfoPerso = null;
	private JPanel pnlAdresse = null;
	 
	public PanelVendeurListener(JPanel pnlInfoPerso, JPanel pnlAdresse){
		this.pnlInfoPerso = pnlInfoPerso;
		this.pnlAdresse = pnlAdresse;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Rechercher")){
			String[] titre = {"Id", "Nom", "Prenom", "Date de naissance", "Civilité", "Selectionner"};
			Object[][] triVendeur = null;
			Transaction tx = null;
			
			Session session = HibernateUtil.instance().openSession();	
			
			if (((SousPanelInfoPersonnel)pnlInfoPerso).getTxtNom().getText().trim().length() > 0){
				List<Vendeur> vendeurs = session.createQuery("FROM Vendeur WHERE nomPersonne LIKE ? ORDER BY nomPersonne, prenomPersonne")
						.setString(0, "%".concat((((SousPanelInfoPersonnel)pnlInfoPerso).getTxtNom().getText().trim())).concat("%")).list();
				if (vendeurs.size() >0 ){
					triVendeur = new Object[vendeurs.size()][titre.length];
					int i = 0;
					for(Vendeur c : vendeurs){
						triVendeur[i][0] = c.getIdPersonne();
						triVendeur[i][1] = c.getNomPersonne();
						triVendeur[i][2] = c.getPrenomPersonne();
						triVendeur[i][3] = c.getDateNaissancePersonne();
						triVendeur[i][4] = c.getSexePersonne();
						triVendeur[i][5] = false;
						i ++;
					}
					JDialog dialogRecherche = new DialogRecherche(titre, triVendeur);
				}else{
					JOptionPane.showMessageDialog(null, "Pas de vendeurs contenant ces caractères !");
				}
			}else{
				JOptionPane.showMessageDialog(null, "Veuillez remplir le champ nom !");
			}			
		}
		
		if (ae.getActionCommand().equals("Enregistrer")){
			((SousPanelInfoPersonnel)pnlInfoPerso).verificationChamp();
			((SousPanelInfoAdresse)pnlAdresse).verificationChamp();
			if( ((SousPanelInfoPersonnel)pnlInfoPerso).verificationChamp() && ((SousPanelInfoAdresse)pnlAdresse).verificationChamp() ){
				if (((SousPanelInfoPersonnel)pnlInfoPerso).verificationDonnees()){
					if ( ((SousPanelInfoPersonnel)pnlInfoPerso).verificationEmail() ){
						Integer tmpId = ((SousPanelInfoAdresse)pnlAdresse).validationDonnee();
						((SousPanelInfoPersonnel)pnlInfoPerso).validationDonneeVendeur(tmpId);
						((SousPanelInfoPersonnel)pnlInfoPerso).remiseZero();
						((SousPanelInfoAdresse)pnlAdresse).remiseZero();
					}
					else{					
						JOptionPane.showMessageDialog(null, "Cet e-mail existe déjà !", "Attention", 1);					
					}
				}
			}
			else{
				JOptionPane.showMessageDialog(null, "Veuillez remplir tous les champs", "Attention", 1);
			}
		}
		
		if (ae.getActionCommand().equals("Annuler")){
			((SousPanelInfoPersonnel)pnlInfoPerso).remiseZero();
			((SousPanelInfoAdresse)pnlAdresse).remiseZero();
		}
	}

}
