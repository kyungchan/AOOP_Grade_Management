package frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import classes.ClassTableModel;

public class MainTablePanel extends JPanel {
	protected JTable scoreTable;
	private ClassTableModel tableModel;
	private String[] columnNames = {"학번", "학생이름", "학년", "출결(10%)", "중간(15%)", 
			"기말(15%)", "과제(20%)", "퀴즈(10%)", "발표(10%)", 
			"보고서(10%)", "기타(10%)"};
	
	public void setTableModel(ClassTableModel tableModel) {
		this.tableModel = tableModel;
	}
	

	public MainTablePanel(ClassTableModel tableModel) {
		setTableModel(tableModel);

		scoreTable = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setPreferredSize(new Dimension(1000, 500));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
				
		scoreTable.getColumn(columnNames[0]).setPreferredWidth(70);
		scoreTable.getColumn(columnNames[0]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[1]).setPreferredWidth(60);
		scoreTable.getColumn(columnNames[1]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[2]).setPreferredWidth(30);
		scoreTable.getColumn(columnNames[2]).setCellRenderer(celAlignCenter);
		scoreTable.changeSelection(10, 0, false, false);
		scoreTable.setCellSelectionEnabled(true);
		setLayout(new GridLayout(1, 0));
		add(scrollPane);
	}

	public ClassTableModel getTableModel() {
		return tableModel;
	}
}
