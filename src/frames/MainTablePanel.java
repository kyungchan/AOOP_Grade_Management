package frames;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableRowSorter;

import classes.ClassTableModel;
import classes.Ratio;

public class MainTablePanel extends JPanel {
	protected JTable scoreTable;
	private ClassTableModel tableModel;
	private String[] columnNames = { "학번", "학생이름", "학년", "출결(10%)", "중간(15%)", "기말(15%)", "과제(20%)", "퀴즈(10%)",
			"발표(10%)", "보고서(10%)", "기타(10%)" };

	private DefaultTableCellRenderer getFixCellCenter = new DefaultTableCellRenderer();
	private TableRowSorter<ClassTableModel> sorter;

	public void setTableModel(ClassTableModel tableModel) {
		this.tableModel = tableModel;
	}

	public TableRowSorter<ClassTableModel> getSorter() {
		return sorter;
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
		scoreTable.setCellSelectionEnabled(true);
		sorter = new TableRowSorter(tableModel);
		scoreTable.setRowSorter(sorter);

		setLayout(new GridLayout(1, 0));
		add(scrollPane);

	}
	public void updateColNames(Ratio ratio) {
		StringBuilder sb = new StringBuilder(columnNames[3]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioAttand());
		columnNames[3] = sb.toString();
		sb = new StringBuilder(columnNames[4]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioMid());
		columnNames[4] = sb.toString();
		sb = new StringBuilder(columnNames[5]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioFinal());
		columnNames[5] = sb.toString();
		sb = new StringBuilder(columnNames[6]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioHomework());
		columnNames[6] = sb.toString();
		sb = new StringBuilder(columnNames[7]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioQuiz());
		columnNames[7] = sb.toString();
		sb = new StringBuilder(columnNames[8]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioPPT());
		columnNames[8] = sb.toString();
		sb = new StringBuilder(columnNames[9]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioReport());
		columnNames[9] = sb.toString();
		sb = new StringBuilder(columnNames[10]);
		sb.delete(sb.length() - 4, sb.length()-2);
		sb.insert(sb.length() - 2, ratio.getRatioEtc());
		columnNames[10] = sb.toString();
		JTableHeader th = scoreTable.getTableHeader();
		TableColumnModel tcm = th.getColumnModel();
		TableColumn tc;
		for(int i = 3; i < 11; i++) {
			tc = tcm.getColumn(i);
			tc.setHeaderValue(columnNames[i]);
		}
		th.resizeAndRepaint();
		scoreTable.repaint();
	}
	public TableCellRenderer getFixCellCenter() {
		return getFixCellCenter;
	}

	public ClassTableModel getTableModel() {
		return tableModel;
	}

}
