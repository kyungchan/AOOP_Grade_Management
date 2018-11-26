package frames;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class AttandTablePanel extends JPanel {
	public AttandTablePanel() {
		String[] columnNames = { "�й�", "�г�", "�л��̸�", "1��-1", "1��-2", "2��-1", "2��-2", "3��-1", "3��-2", "4��-1", "4��-2",
				"5��-1", "5��-2", "6��-1", "6��-2", "7��-1", "7��-2", "8��-1", "8��-2", "9��-1", "9��-2", "10��-1", "10��-2",
				"11��-1", "11��-2", "12��-1", "12��-2", "13��-1", "13��-2", "14��-1", "14��-2", "15��-1", "15��-2", "16��-1",
				"16��-2" };
		Object[][] data = { { "60142626", "3", "������", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
				"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O" },
				{ "60142626", "3", "������", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
					"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O" },
				{ "60142626", "3", "������", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
						"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O" },
				{ "60142626", "3", "������", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O",
							"O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O", "O" }};

		JTable scoreTable = new JTable(data, columnNames) {
				  public boolean isCellEditable(int row,int column){
		    if(column == 0 || column == 1 || column == 2) return false;
		    return true;
		  };
		};
		JScrollPane scrollPane = new JScrollPane(scoreTable);

		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		scoreTable.getColumn(columnNames[0]).setPreferredWidth(70);
		scoreTable.getColumn(columnNames[0]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[1]).setPreferredWidth(30);
		scoreTable.getColumn(columnNames[1]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[2]).setPreferredWidth(60);
		scoreTable.getColumn(columnNames[2]).setCellRenderer(celAlignCenter);
		for (int i = 3; i < 35; i++) {
			scoreTable.getColumn(columnNames[i]).setPreferredWidth(45);
			scoreTable.getColumn(columnNames[i]).setCellRenderer(celAlignCenter);
		}

		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scoreTable.setCellSelectionEnabled(true);
		setLayout(new GridLayout(1, 0));
		add(scrollPane);
	}
}
