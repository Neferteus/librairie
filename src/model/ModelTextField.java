package model;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class ModelTextField extends JTextField {
	private int longueur;
	
	public ModelTextField(int longueur){
		super();
		this.longueur = longueur;
		build();
	}

	private void build() {
		this.addKeyListener(new clavierListener(this, longueur));
	}
}

class clavierListener implements KeyListener{
	private int longueur;
	private JTextField txt = null;
	
	public clavierListener(JTextField txt, int longueur){
		this.txt = txt;
		this.longueur = longueur;
	}
	
	@Override
	public void keyReleased(KeyEvent ke) {
		if (txt.getText().length() > longueur){
			txt.setText(txt.getText().replace(txt.getText().substring(longueur), ""));
		}
	}
	@Override
	public void keyPressed(KeyEvent ke) { }
	@Override
	public void keyTyped(KeyEvent ke) { }
}
