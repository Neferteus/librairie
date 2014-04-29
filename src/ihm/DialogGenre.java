package ihm;

import java.awt.Dialog.ModalityType;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDialog;
import javax.swing.JFrame;

import org.hibernate.Session;

import test.HibernateUtil;

public class DialogGenre extends JDialog {
	private Session session = null;
	private String[] libelle = {"id", "Genre", "Selectionner"};
	private JDialog dialog = null;

	public DialogGenre() {
		super();
		this.dialog = this;
		build();
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				dialog.dispose();
			}
		});
		
		session = HibernateUtil.instance().openSession();
		
		
		this.setModalityType(ModalityType.TOOLKIT_MODAL);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}
