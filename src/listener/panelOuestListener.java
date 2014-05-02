package listener;

import ihm.FenetrePrincipal;
import ihm.PanelCentre;
import ihm.PanelOuest;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;

public class panelOuestListener implements ActionListener{
	private int change;
	
	public panelOuestListener(int i){
		this.change = i;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		PanelCentre.changeContenu(change);
	}

}
