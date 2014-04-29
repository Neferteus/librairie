package ihm;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPersonnel extends JMenuBar {
	private JMenu fichier = null;	
	private JMenu aide = null;

	private JMenuItem connexion = null;
	private JMenuItem deconnexion = null;
	private JMenuItem quitter = null;
	private JMenuItem info = null;
	public MenuPersonnel(){
		super();
		build();
	}

	private void build() {
		fichier = new JMenu("Fichier");	
		connexion = new JMenuItem("Connexion");
		deconnexion = new JMenuItem("Deconnexion");
		quitter = new JMenuItem("Quitter");
		fichier.add(connexion);
		fichier.add(deconnexion);
		fichier.addSeparator();
		fichier.add(quitter);
		
		aide = new JMenu("Aide");
		info = new JMenuItem("A propos de");
		aide.add(info);
		
		this.add(fichier);
		this.add(aide);
	}
}
