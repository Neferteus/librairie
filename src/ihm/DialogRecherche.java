package ihm;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import model.ModelRecherche;

public class DialogRecherche extends JDialog{
	private String[] titre = null;
	private Object[][] donnees = null;
	private JDialog dialog = null;
	private JTable tabResult = null;
	private AbstractTableModel model = null;	
	
	public DialogRecherche(String[] titre, Object[][] donnees){
		super();
		dialog = this;
		this.titre = titre;
		this.donnees = donnees;
		build();
	}

	private void build() {
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e){
				dialog.dispose();
			}
		});
		this.setLayout(new BorderLayout());
		
		model = new ModelRecherche(titre, donnees);
		tabResult = new JTable(model);
		
		this.getContentPane().add(new JScrollPane(tabResult), BorderLayout.CENTER);	
		
		this.setModalityType(ModalityType.TOOLKIT_MODAL);
		this.pack();
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}

}
