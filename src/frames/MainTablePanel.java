package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;

import classes.ClassTableModel;

public class MainTablePanel extends JPanel {
	protected JTable scoreTable;
	private ClassTableModel tableModel;
	private String[] columnNames = { "�й�", "�л��̸�", "�г�", "���(10%)", "�߰�(15%)", "�⸻(15%)", "����(20%)", "����(10%)",
			"��ǥ(10%)", "����(10%)", "��Ÿ(10%)" };

	private DefaultTableCellRenderer getFixCellCenter = new DefaultTableCellRenderer();

	public void setTableModel(ClassTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public MainTablePanel(ClassTableModel tableModel) {
		setTableModel(tableModel);

		scoreTable = new JTable(getTableModel());
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setPreferredSize(new Dimension(1000, 500));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		getFixCellCenter.setHorizontalAlignment(JLabel.CENTER);
		getFixCellCenter.setBackground(Color.decode("#F2F2F2"));

		scoreTable.getColumn(columnNames[0]).setPreferredWidth(70);
		scoreTable.getColumn(columnNames[0]).setCellRenderer(getFixCellCenter);
		scoreTable.getColumn(columnNames[1]).setPreferredWidth(60);
		scoreTable.getColumn(columnNames[1]).setCellRenderer(getFixCellCenter);
		scoreTable.getColumn(columnNames[2]).setPreferredWidth(30);
		scoreTable.getColumn(columnNames[2]).setCellRenderer(getFixCellCenter);
		scoreTable.changeSelection(10, 0, false, false);
		scoreTable.setCellSelectionEnabled(true);
		scoreTable.setRowSorter(new TableRowSorter(tableModel));
		setLayout(new GridLayout(1, 0));
		add(scrollPane);

	}

	public TableCellRenderer getFixCellCenter() {
		return getFixCellCenter;
	}

	public ClassTableModel getTableModel() {
		return tableModel;
	}

}
