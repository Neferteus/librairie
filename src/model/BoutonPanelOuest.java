package model;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;

import listener.PanelOuestListener;

public class BoutonPanelOuest extends JButton {
	private int choix;
	private String nom = null;
	private String path = null;
	
	// *** Rajouter le chemin de l'image ***
	public BoutonPanelOuest(String nom, String path, int choix){
		super();
		this.nom = nom;
		this.path = path; 
		this.choix = choix;
		build();
	}

	private void build() {
		this.setPreferredSize(new Dimension(120, 20));
		this.addActionListener(new PanelOuestListener(choix));
	}

	public void paintComponent(Graphics g){
		Font font = new Font("Verdana", Font.PLAIN, 18);
		Image img;
		try {
			img = ImageIO.read(new File(path));
			g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		g.setFont(font);
		g.setColor(Color.RED);
		g.drawString(this.nom, 10, this.getHeight()/2);
	}
	
}
