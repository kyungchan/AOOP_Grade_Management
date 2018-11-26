package frames;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class MainTablePanel extends JPanel {
	DefaultTableModel model;
	
	public MainTablePanel() {
		String[] columnNames = {"�й�", "�г�", "�л��̸�", "���(10%)", "�߰�(15%)", 
								"�⸻(15%)", "����(20%)", "����(10%)", "��ǥ(10%)", 
								"����(10%)", "��Ÿ(10%)"};
		Object[][] data = {
	            {"60142626", "3", "������", "100","100","100","0","80","79","70","80"},
	            {"60142525", "4", "�賲ȫ", "90","95","30","50","30","54","80","100"},
	            {"60172198", "2", "�輭��", "80","20","20","70","10","66","70","100"},
	            {"60152321", "3", "�輱��", "100","100","100","0","80","79","90","100"},
	            {"60121877", "4", "������", "90","95","30","50","30","54","95","100"},
	            {"60172101", "2", "�ڼ���", "50","20","34","49","22","66","100","100"},
	            {"60172164", "2", "������", "100","70","40","70","55","66","80","100"},
	            {"60172122", "2", "�輺��", "70","50","24","43","82","66","80","100"},
	            {"60131455", "3", "�Ѽ���", "20","40","20","70","30","66","100","100"},
	            {"60151678", "2", "�ڴ���", "100","68","30","60","80","66","50","80"},
	            {"60171423", "2", "������", "60","70","40","40","90","66","60","80"},
	            {"60141287", "4", "������", "80","64","80","100","85","66","100","90"},
	            {"60161125", "2", "�Ӽ���", "60","63","80","60","65","66","70","90"},
	            {"60162265", "2", "������", "80","50","56","60","90","66","70","70"},
	            {"60151541", "2", "����ȣ", "70","79","30","63","70","66","60","80"},
	            {"60182154", "1", "��ä��", "100","67","66","88","30","66","50","100"},
	            {"60161236", "2", "������", "100","2","0","0","6","66","50","90"},
	            {"60171367", "2", "�ں���", "90","51","92","91","72","66","100","80"},
	            {"60171648", "2", "������", "60","17","44","32","63","66","50","100"},
	            {"60152001", "2", "�����", "80","0","0","0","0","66","80","90"},
	            {"60161369", "2", "��â��", "40","14","28","40","30","66","60","100"},
	            {"60112147", "4", "����ȯ", "70","59","13","34","74","66","70","100"},
	            {"60161762", "2", "�輼��", "90","98","100","92","94","66","80","100"},
	            {"60171662", "2", "�����", "100","100","89","90","100","66","60","100"},
	            {"60152156", "2", "��ö��", "80","24","30","47","32","66","30","100"},
	            {"60172214", "2", "�����", "90","39","8","71","51","66","10","100"},
	            {"60141542", "3", "������", "60","59","73","73","65","66","60","100"},
	            {"60141460", "3", "�Ӽ���", "80","52","92","96","55","66","40","100"},
	            {"60161666", "3", "����", "70","51","76","62","71","66","20","100"},
	            {"60172133", "2", "�翹��", "50","42","37","50","52","66","60","80"},
	            {"60142167", "2", "���ҹ�", "30","44","10","70","53","66","70","100"},
	            {"60172030", "2", "�����", "80","86","77","88","96","66","80","100"}
		};
		model = new DefaultTableModel(data, columnNames);
		JTable scoreTable = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(scoreTable);
		scrollPane.setPreferredSize(new Dimension(1000, 500));
		scoreTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		DefaultTableCellRenderer celAlignCenter = new DefaultTableCellRenderer();
		celAlignCenter.setHorizontalAlignment(JLabel.CENTER);
		scoreTable.getColumn(columnNames[0]).setPreferredWidth(70);
		scoreTable.getColumn(columnNames[0]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[1]).setPreferredWidth(30);
		scoreTable.getColumn(columnNames[1]).setCellRenderer(celAlignCenter);
		scoreTable.getColumn(columnNames[2]).setPreferredWidth(60);
		scoreTable.getColumn(columnNames[2]).setCellRenderer(celAlignCenter);
		scoreTable.changeSelection(10, 0, false, false);
		scoreTable.setCellSelectionEnabled(true);
		setLayout(new GridLayout(1, 0));
		add(scrollPane);
	}
}
