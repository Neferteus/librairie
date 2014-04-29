package ihm;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

public class LabelNord extends JLabel {
	
	public LabelNord(){
		super();
		build();
	}

	private void build() {
		this.setText("Oh Book'Hein");
		this.setFont(new Font("Verdana", 3, 24));
		this.setForeground(Color.BLACK);
		this.setOpaque(true);
		this.setBackground(Color.WHITE);
		this.setHorizontalAlignment(JLabel.CENTER);
	}
}
