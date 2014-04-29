package ihm;

import java.awt.BorderLayout;
import java.awt.Dialog.ModalityType;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import test.HibernateUtil;

public class FenetrePrincipal extends JFrame {
	private Session session = HibernateUtil.instance().openSession();
	private static boolean responsable = false;
	private JFrame frame = null;
	private JLabel labelNord = null;
	private JPanel panelOuest = null;
	private JPanel panelCentre = null;
	private JScrollPane scrollCentre = null;
	private JMenuBar menu = null;
	private JDialog dialConnexion = null;
	
	public FenetrePrincipal(){
		super();
		this.frame = this;
		build();
	}
	
	private void build() {
		this.setTitle("Gestion d'une librairie");
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				int i = JOptionPane.showConfirmDialog(null, "Etes-vous sur de vouloir quitter ?", "Confirmation", JOptionPane.YES_NO_OPTION, 2);
				if (i == 0){
					System.exit(0);
				}
			}
		});
		dialConnexion = new DialogConnexion();
		
		menu = new MenuPersonnel();
		this.setJMenuBar(menu);
		labelNord = new LabelNord();
		panelCentre = new PanelCentre();
		scrollCentre = new JScrollPane(panelCentre);
		panelOuest = new PanelOuest(panelCentre, responsable);
		
		this.getContentPane().add(labelNord, BorderLayout.NORTH);
		this.getContentPane().add(panelOuest, BorderLayout.WEST);
		this.getContentPane().add(scrollCentre, BorderLayout.CENTER);
		
		this.setSize(new Dimension(700, 800));
		// this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		
	}

	public static boolean isResponsable() {
		return responsable;
	}

	public static void setResponsable(boolean responsable) {
		FenetrePrincipal.responsable = responsable;
	}
	
}
