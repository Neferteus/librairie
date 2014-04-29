package model;

import javax.swing.table.AbstractTableModel;

public class ModelRecherche extends AbstractTableModel {
	private Object[][] data;
	private String[] title;
	
	public ModelRecherche(String[] title, Object[][] data) {
		super();
		this.data = data;
		this.title = title;
	}

	@Override
	public int getColumnCount() {
		return this.title.length;
	}

	@Override
	public int getRowCount() {
		return this.data.length;
	}

	@Override
	public Object getValueAt(int ligne, int colonne) {
		return this.data[ligne][colonne];
	}

	// Afficher le nom des colonnes
	@Override
	public String getColumnName(int column) {
		return this.title[column];
	}

	// Avoir des cases à cocher pour les boolean
	@Override
	public Class getColumnClass(int col) {
		return this.data[0][col].getClass();
	}
	
	

}
