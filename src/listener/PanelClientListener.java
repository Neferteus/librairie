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
import org.hibernate.event.internal.OnLockVisitor;

import pojo.Client;
import pojo.Vendeur;
import test.HibernateUtil;

public class PanelClientListener implements ActionListener{
	private JPanel pnlInfoPerso = null;
	private JPanel pnlAdresse = null;
	 
	public PanelClientListener(JPanel pnlInfoPerso, JPanel pnlAdresse){
		this.pnlInfoPerso = pnlInfoPerso;
		this.pnlAdresse = pnlAdresse;
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		if (ae.getActionCommand().equals("Rechercher")){
			String recherche = "%".concat((((SousPanelInfoPersonnel)pnlInfoPerso).getTxtNom().getText().trim())).concat("%");
			String[] titre = {"Id", "Nom", "Prenom", "Date de naissance", "Civilité"};
			Object[][] triClient = null;
			Transaction tx = null;
			
			Session session = HibernateUtil.instance().openSession();
			
			if (((SousPanelInfoPersonnel)pnlInfoPerso).getTxtNom().getText().trim().length() > 0){
				List<Client> clients = session.createQuery("FROM Client WHERE nomPersonne LIKE ? ORDER BY nomPersonne, prenomPersonne")
						.setString(0, recherche).list();
				if (clients.size() >0 ){
					triClient = new Object[clients.size()][titre.length];
					int i = 0;
					for(Client c : clients){
						triClient[i][0] = c.getIdPersonne();
						triClient[i][1] = c.getNomPersonne();
						triClient[i][2] = c.getPrenomPersonne();
						triClient[i][3] = c.getDateNaissancePersonne();
						triClient[i][4] = c.getSexePersonne();
						i ++;
					}
					JDialog dialogRecherche = new DialogRecherche(titre, triClient);
				}else{
					JOptionPane.showMessageDialog(null, "Pas de clients contenant ces caractères !");
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
					if (((SousPanelInfoPersonnel)pnlInfoPerso).verificationEmail()){
						Integer tmpId = ((SousPanelInfoAdresse)pnlAdresse).validationDonnee();
						((SousPanelInfoPersonnel)pnlInfoPerso).validationDonneeClient(tmpId);
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
