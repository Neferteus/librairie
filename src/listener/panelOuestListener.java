package listener;

import ihm.FenetrePrincipal;
import ihm.PanelCentre;
import ihm.PanelOuest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class panelOuestListener implements ActionListener{
	private int change;
	private JPanel pnlCentre = null;
	private JPanel pnlRaz = null;
	
	public panelOuestListener(JPanel panel, int i){
		this.pnlCentre = panel;
		this.change = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		((PanelCentre)pnlCentre).remiseZero();
		((PanelCentre)pnlCentre).changeContenu(change);
	}

}
