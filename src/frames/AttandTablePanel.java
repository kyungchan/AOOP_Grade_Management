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
		String[] columnNames = { "切锅", "切斥", "切积捞抚", "免籍", "瘤阿", "搬籍", "1林-1", "1林-2", "2林-1", "2林-2", "3林-1", "3林-2",
				"4林-1", "4林-2", "5林-1", "5林-2", "6林-1", "6林-2", "7林-1", "7林-2", "8林-1", "8林-2", "9林-1", "9林-2", "10林-1",
				"10林-2", "11林-1", "11林-2", "12林-1", "12林-2", "13林-1", "13林-2", "14林-1", "14林-2", "15林-1", "15林-2",
				"16林-1", "16林-2" };
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
