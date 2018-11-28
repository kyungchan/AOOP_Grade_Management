package frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import classes.ResultSetTableModel;

public class MainTablePanel extends JPanel {
	private ResultSetTableModel tableModel;
	
	public void setTableModel(ResultSetTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public MainTablePanel(ResultSetTableModel tableModel) {
		setTableModel(tableModel);
		String[] columnNames = {"학번", "학생이름", "학년", "출결(10%)", "중간(15%)", 
								"기말(15%)", "과제(20%)", "퀴즈(10%)", "발표(10%)", 
								"보고서(10%)", "기타(10%)"};
		JTable scoreTable = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setPreferredSize(new Dimension(1000, 500));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		
		for(int i = 0; i < columnNames.length; i++) {
			scoreTable.getTableHeader().getColumnModel().getColumn(i).setHeaderValue(columnNames[i]);
			scoreTable.getTableHeader().repaint();
		}
		
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

	public ResultSetTableModel getTableModel() {
		return tableModel;
	}
}
