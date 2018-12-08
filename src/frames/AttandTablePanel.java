package frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

import classes.ClassTableModel;

public class AttandTablePanel extends JPanel {
	private ClassTableModel attandModel;
	protected JTable scoreTable;

	public AttandTablePanel(ClassTableModel attandModel) {
		String[] columnNames = { "�й�", "�г�", "�л��̸�", "�⼮", "����", "�Ἦ", "1��-1", "1��-2", "2��-1", "2��-2", "3��-1", "3��-2",
				"4��-1", "4��-2", "5��-1", "5��-2", "6��-1", "6��-2", "7��-1", "7��-2", "8��-1", "8��-2", "9��-1", "9��-2", "10��-1",
				"10��-2", "11��-1", "11��-2", "12��-1", "12��-2", "13��-1", "13��-2", "14��-1", "14��-2", "15��-1", "15��-2",
				"16��-1", "16��-2" };
		setAttandModel(attandModel);
		scoreTable = new JTable(getAttandModel()) {
			public boolean isCellEditable(int row, int column) {
				return false;
			};
		};
		JScrollPane scrollPane = new JScrollPane(scoreTable);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		for (int i = 0; i < 38; i++) {
			scoreTable.getColumn(columnNames[i]).setPreferredWidth(45);
			scoreTable.getColumn(columnNames[i]).setCellRenderer(celAlignCenter);
		}

		scoreTable.getColumn(columnNames[0]).setPreferredWidth(70);
		scoreTable.getColumn(columnNames[1]).setPreferredWidth(30);
		scoreTable.getColumn(columnNames[2]).setPreferredWidth(60);
		scrollPane.setPreferredSize(new Dimension(900, 500));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scoreTable.setCellSelectionEnabled(true);
		setLayout(new GridLayout(1, 0));
		add(scrollPane);
	}

	public JTable getScoreTable() {
		return scoreTable;
	}

	public ClassTableModel getAttandModel() {
		return attandModel;
	}

	public void setAttandModel(ClassTableModel attandModel) {
		this.attandModel = attandModel;
	}
}
